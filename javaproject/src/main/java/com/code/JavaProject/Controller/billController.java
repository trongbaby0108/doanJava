package com.code.JavaProject.Controller;

import com.code.JavaProject.Entity.bill;
import com.code.JavaProject.Entity.detail_Bill;
import com.code.JavaProject.Entity.product;
import com.code.JavaProject.Model.bill_model;
import com.code.JavaProject.Model.detail_BillModel;
import com.code.JavaProject.Model.responeBillModel;
import com.code.JavaProject.Service.accountService;
import com.code.JavaProject.Service.billService;
import com.code.JavaProject.Service.detail_BillService;
import com.code.JavaProject.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class billController {
    @Autowired
    private billService billService ;

    @Autowired
    private productService productService ;

    @Autowired
    private detail_BillService detail_BillService;

    @Autowired
    private accountService accountService;

    @PostMapping("/checkout")
    public String save(@RequestBody bill_model bill_model) throws Exception {
        bill bill = new bill();
        bill.setCreateAt(LocalDateTime.now());
        bill.setName(bill_model.getName());
        bill.setAddress(bill_model.getAddress());
        bill.setPhone(bill_model.getPhone());
        billService.save(bill);
        for (detail_BillModel detail_BillModel: bill_model.getDetailList()) {
            product product = productService.findByName(detail_BillModel.getProductModel().getName());
            if(product == null) throw new Exception("not find product");
            if(product.getQuantity() < detail_BillModel.getQuality())
                    throw new Exception("not enough");
            else {
                product.setQuantity(product.getQuantity() - detail_BillModel.getQuality()   );
                productService.save(product);
            }

            detail_Bill detail_bill = new detail_Bill();
            detail_bill.setProduct(product);
            detail_bill.setQuality(detail_BillModel.getQuality());
            detail_bill.setBill(bill);
            detail_BillService.save(detail_bill);
        }
        return "ok";
    }

    @GetMapping("getAll")
    public List<responeBillModel> getAll(){
        List<responeBillModel> res = new ArrayList<>();
        for (bill bill: billService.getAll()) {
            responeBillModel responeBillModel = new responeBillModel();
            responeBillModel.setId(bill.getId());
            responeBillModel.setName(bill.getName());
            responeBillModel.setAddress(bill.getAddress());
            responeBillModel.setCreateAt(bill.getCreateAt().toString());
            responeBillModel.setPhone(bill.getPhone());
            res.add(responeBillModel);
        }
        return res;
    }

}
