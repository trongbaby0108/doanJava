package com.code.DoanJAVA.Controller;

import com.code.DoanJAVA.Entity.category;
import com.code.DoanJAVA.Service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/signup")
public class categoryController {
    @Autowired
    private categoryService categoryService;

    @GetMapping(value = "getAll")
    private List<category> getAll(){
        return categoryService.getAll();
    }


}
