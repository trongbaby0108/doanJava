package com.example.sanpham;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lib.Interface.IChuyenData;
import com.example.lib.Model.Invoice;
import com.example.lib.Model.cartItem;
import com.example.lib.Model.product;
import com.example.lib.Model.userResponse;
import com.example.sanpham.Fragment.CartFragment;
import com.example.sanpham.Fragment.DangNhapFragment;
import com.example.sanpham.Fragment.Fragment_detail;
import com.example.sanpham.Fragment.HomeFragment;
import com.example.sanpham.Fragment.Profile_Fragment;
import com.example.sanpham.Fragment.fragmentproduct;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;

public class MainActivity extends AppCompatActivity implements IChuyenData, Serializable{

    public MainActivity(){

    }

    public ChipNavigationBar ChipNavigationBar;
    Context context;

    private userResponse taiKhoan;
    public TedBottomPicker tedBottomPicker;
    public List<cartItem> cartItems;
    public String token;
    public boolean IsGoogle;
    public userResponse getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(userResponse taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public MainActivity(userResponse taiKhoan ){
        this.taiKhoan = taiKhoan;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        ChipNavigationBar = findViewById(R.id.menu_1);
        ChipNavigationBar.setItemSelected(R.id.fragment_home, true);
        cartItems = new ArrayList<>();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, new HomeFragment());
        fragmentTransaction.addToBackStack("Fragment home");
        fragmentTransaction.commit();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token =  bundle.getString("jwt");
            taiKhoan = (userResponse) bundle.getSerializable("data");
            IsGoogle = bundle.getBoolean("isGoogle");
            //Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        }
        MenuClick();
    }


    private void MenuClick() {
        ChipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                Fragment fragment = null;
                switch (i) {
                    case R.id.fragment_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.menu_nav_buy:
                        fragment = new CartFragment();
                        break;
                    case R.id.fragmentproduct:
                        fragment = new fragmentproduct();
                        break;
                    case R.id.menu_nav_user:
                        if(taiKhoan ==  null)
                            fragment = new DangNhapFragment();
                        else
                            fragment = new Profile_Fragment(taiKhoan);
                        break;
                }
                fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
                fragmentTransaction.addToBackStack("Fragment home");
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void ChuyenData(product p) {
        Bundle bundle = new Bundle();
        Serializable x = p;
        bundle.putSerializable("product", x);
        Fragment_detail temp = new Fragment_detail();
        temp.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, temp).commit();
        fragmentTransaction.addToBackStack("Fragment Detail");
    }

    @Override
    public void PassDetailBill(Invoice bill) {
        Bundle bundle = new Bundle();
        Serializable x = bill;
        bundle.putSerializable("bill", x);
        Fragment_detail temp = new Fragment_detail();
        temp.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, temp).commit();
        fragmentTransaction.addToBackStack("Fragment Invoice");
    }


}