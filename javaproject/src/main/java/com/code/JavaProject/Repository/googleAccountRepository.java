package com.code.JavaProject.Repository;

import com.code.JavaProject.Entity.googleAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface googleAccountRepository extends JpaRepository<googleAccount,Integer> {
    googleAccount findByEmail(String email);
}
