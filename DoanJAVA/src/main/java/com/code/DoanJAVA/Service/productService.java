package com.code.DoanJAVA.Service;

import com.code.DoanJAVA.Entity.product;

import java.util.List;


public interface productService {
    public void save(product product);
    public product findByName(String name);
    public List<product> getAll();

    public product findById(int id);

    public void delete(int id);
}
