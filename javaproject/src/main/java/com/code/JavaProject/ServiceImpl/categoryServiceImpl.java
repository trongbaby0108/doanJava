package com.code.JavaProject.ServiceImpl;

import com.code.JavaProject.Entity.category;
import com.code.JavaProject.Repository.categoryRepository;
import com.code.JavaProject.Service.categoryService;
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
