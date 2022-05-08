package com.code.DoanJAVA.Repository;

import com.code.DoanJAVA.Entity.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepository extends JpaRepository<account,Integer> {
    public account findByUsername(String username);
}
