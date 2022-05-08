package com.code.DoanJAVA.ServiceImpl;

import com.code.DoanJAVA.Entity.category;
import com.code.DoanJAVA.Repository.categoryRepository;
import com.code.DoanJAVA.Service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryServiceImpl implements categoryService {
    @Autowired
    private categoryRepository categoryRepository;
    @Override
    public List<category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void save(category category) {
        categoryRepository.save(category);
    }
}
