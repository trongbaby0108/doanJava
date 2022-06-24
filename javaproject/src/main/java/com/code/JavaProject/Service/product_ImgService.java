package com.code.JavaProject.Service;

import com.code.JavaProject.Entity.product_Img;

import java.util.List;

public interface product_ImgService {
    public void save(product_Img product_img);
    public List<product_Img> getByProduct(String name);

    public void delete(int id);
}
