package com.code.DoanJAVA.Repository;

import com.code.DoanJAVA.Entity.token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tokenRepository extends JpaRepository<token,Integer> {
    public token findByToken(String token);

}
