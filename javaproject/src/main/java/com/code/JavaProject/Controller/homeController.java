package com.code.JavaProject.Controller;

import com.code.JavaProject.Entity.category;
import com.code.JavaProject.Entity.product;
import com.code.JavaProject.Entity.product_Img;
import com.code.JavaProject.Model.productModel;
import com.code.JavaProject.Service.categoryService;
import com.code.JavaProject.Service.productService;
import com.code.JavaProject.Service.product_ImgService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping(value = "home")
public class homeController {
    @Autowired
    private productService productService;

    @Autowired
    private product_ImgService product_ImgService;

    @Autowired
    private categoryService categoryService;

    @GetMapping(value = "getAll")
    public List<productModel> getAll(){
        List<productModel> result = new ArrayList<>();
        List<product> products = productService.getAll();
        for (product product: products) {
            productModel temp = new productModel();
            if(product.isEnable()){
                temp.setName(product.getName());
                temp.setPrice_out(product.getPrice_out());
                temp.setCategory(product.getCategory());
                temp.setImg(product.getImg());
                temp.setQuantity(product.getQuantity());
                result.add(temp);
            }
        }
        return result;
    }
    @GetMapping(value = "getImgByProduct")
    public List<String> getImgByProduct(@RequestParam("name") String name ){
        List<product_Img> imgs = product_ImgService.getByProduct(name);
        List<String> res = new ArrayList<>();
        for (product_Img img: imgs) {
            res.add(img.getImg());
        }
        return res;
    }

    @GetMapping(value = "getCate")
    public List<category> getCate(){
        return categoryService.getAll();
    }

    @GetMapping(value = "getByCate")
    public List<productModel> getByCate(@RequestParam("cate")String name){
        List<productModel> result = new ArrayList<>();
        for (product product: productService.getAll()) {
            if(product.getCategory().getName().equals(name)){
                productModel temp = new productModel();
                temp.setName(product.getName());
                temp.setPrice_out(product.getPrice_out());
                temp.setCategory(product.getCategory());
                temp.setImg(product.getImg());
                result.add(temp);
            }
        }
        return result;
    }

    @GetMapping(value = "find")
    public List<productModel> find(@RequestParam("kw")String kw){
        List<productModel> result = new ArrayList<>();
        for (product product: productService.getAll()) {
            if(product.getName().toLowerCase().contains(kw.toLowerCase())){
                if(product.isEnable()){
                    productModel temp = new productModel();
                    temp.setName(product.getName());
                    temp.setPrice_out(product.getPrice_out());
                    temp.setCategory(product.getCategory());
                    temp.setImg(product.getImg());
                    result.add(temp);
                }
            }
        }
        return result;
    }

    @PostMapping(value = "getSameCate")
    public List<productModel> getSameCate(@RequestBody productModel productModel){
        List<productModel> result = new ArrayList<>();
        for (product product: productService.getAll()) {
            if(
                    product.getCategory().getName()
                        .equals(productModel.getCategory().getName())
                    && !product.getName().equals(productModel.getName())
            ){
                productModel temp = new productModel();
                temp.setName(product.getName());
                temp.setPrice_out(product.getPrice_out());
                temp.setCategory(product.getCategory());
                temp.setImg(product.getImg());
                result.add(temp);
            }
        }
        return result;
    }

}
