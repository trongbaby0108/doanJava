package com.code.DoanJAVA.Service;

import com.code.DoanJAVA.Entity.product_Img;

import java.util.List;

public interface product_ImgService {
    public void save(product_Img product_img);
    public List<String> getByProduct(String name);
}
