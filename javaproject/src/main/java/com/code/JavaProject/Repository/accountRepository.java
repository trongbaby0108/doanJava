package com.code.JavaProject.Repository;

import com.code.JavaProject.Entity.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepository extends JpaRepository<account,Integer> {
    public account findByUsername(String username);
}
