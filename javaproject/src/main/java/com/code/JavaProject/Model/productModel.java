package com.code.JavaProject.Model;

import com.code.JavaProject.Entity.category;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class productModel {
    private String name ;
    private float price_out;
    private category category;
    private String img;
    private float quantity;
}
