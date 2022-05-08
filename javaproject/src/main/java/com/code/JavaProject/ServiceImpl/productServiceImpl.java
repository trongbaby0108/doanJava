package com.code.JavaProject.ServiceImpl;

import com.code.JavaProject.Repository.productRepository;
import com.code.JavaProject.Service.productService;
import com.code.JavaProject.Entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class productServiceImpl implements productService {

    @Autowired
    private productRepository productRepo;

    @Override
    public void save(product product) {
        productRepo.save(product);
    }

    @Override
    public product findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public product findById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void delete(int id) {
        productRepo.delete(productRepo.findById(id).get());
    }
}
