package com.code.DoanJAVA.Controller;

import com.code.DoanJAVA.Entity.product_Img;
import com.code.DoanJAVA.Model.Uploader;
import com.code.DoanJAVA.Service.productService;
import com.code.DoanJAVA.Entity.product;
import com.code.DoanJAVA.Service.product_ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "product")
public class productControlller {
    @Autowired
    private productService productService;

    @Autowired
    private product_ImgService product_ImgService;

    @Autowired
    private com.code.DoanJAVA.Service.categoryService categoryService;

    @GetMapping(value = "getAll")
    public List<product> getAll(){
        return productService.getAll();
    }

    @PostMapping(value = "save")
    public void save(
        @RequestParam("name") String name ,
        @RequestParam("quantity") float quantity ,
        @RequestParam("price_in") float price_in ,
        @RequestParam("price_out") float price_out,
        @RequestParam("pic") MultipartFile pic,
        @RequestParam("category") int category_id
    ){
        Uploader uploader = new Uploader();
        product product = new product();
        product.setDay_Create(LocalDateTime.now());
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice_in(price_in);
        product.setPrice_out(price_out);
        product.setImg(uploader.uploadFile(pic));
        product.setCategory(categoryService.findById(category_id));
        productService.save(product);
        product_Img product_img = new product_Img();
        product_img.setImg(uploader.uploadFile(pic));
        product_img.setProduct(product);
        product_ImgService.save(product_img);
    }

    @PostMapping(value = "update")
    public product update(@RequestParam int id , @RequestBody product p){
        product product = productService.findById(id);
        product.setDay_Update(LocalDateTime.now());
        if(p.getName().trim() != "")
            product.setName(p.getName());

        if(p.getPrice_in() != 0)
            product.setPrice_in(p.getPrice_in());

        if(p.getPrice_out() != 0)
            product.setPrice_out(p.getPrice_out());

        if(p.getQuantity() != 0)
            product.setQuantity(p.getQuantity());

        productService.save(product);
        return product;
    }

    @GetMapping(value = "delete")
    public void update(@RequestParam int id){
        productService.delete(id);
    }

    @GetMapping(value = "addImg")
    public void addImg(
            @RequestParam("name") String name ,
            @RequestParam("pic") MultipartFile pic
            ){
        Uploader uploader = new Uploader();
        product_Img product_img = new product_Img();
        product_img.setProduct(productService.findByName(name));
        product_img.setImg(uploader.uploadFile(pic));
        product_ImgService.save(product_img);
    }

}
