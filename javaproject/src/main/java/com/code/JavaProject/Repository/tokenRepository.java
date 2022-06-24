package com.code.JavaProject.Repository;

import com.code.JavaProject.Entity.token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tokenRepository extends JpaRepository<token,Integer> {
    public token findByToken(String token);

}
