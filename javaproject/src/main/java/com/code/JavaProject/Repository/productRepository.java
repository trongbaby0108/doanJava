package com.code.JavaProject.Repository;

import com.code.JavaProject.Entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product,Integer> {
    public product findByName(String name);
}
