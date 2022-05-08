package com.code.JavaProject.Controller;

import com.code.JavaProject.Entity.category;
import com.code.JavaProject.Entity.googleAccount;
import com.code.JavaProject.Service.googleAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/googleAccount")
public class googleAccountController {
    @Autowired
    private googleAccountService googleAccountService;

    @GetMapping(value = "get")
    private googleAccount get(@RequestParam("email") String email){
        return googleAccountService.get(email);
    }


    @GetMapping(value = "update")
    private String update(
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone
    ){
        googleAccountService.update(email,address,phone);
        return "succes";
    }


}
