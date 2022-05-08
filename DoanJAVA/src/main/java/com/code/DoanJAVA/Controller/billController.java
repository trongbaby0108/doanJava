package com.code.DoanJAVA.Controller;

import com.code.DoanJAVA.Entity.bill;
import com.code.DoanJAVA.Entity.detail_Bill;
import com.code.DoanJAVA.Entity.product;
import com.code.DoanJAVA.Model.bill_model;
import com.code.DoanJAVA.Model.detail_BillModel;
import com.code.DoanJAVA.Service.accountService;
import com.code.DoanJAVA.Service.billService;
import com.code.DoanJAVA.Service.detail_BillService;
import com.code.DoanJAVA.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
        bill.setAccount(accountService.getByUserName(bill_model.getUsername()));
        bill.setCreateAt(LocalDateTime.now());
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

}
