package com.code.JavaProject.ServiceImpl;

import com.code.JavaProject.Entity.token;

import com.code.JavaProject.Repository.tokenRepository;
import com.code.JavaProject.Service.tokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tokenServiceImpl implements tokenService {

    @Autowired
    private tokenRepository tokenRepository;
    @Override
    public token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void save(token signin_Token) {
        tokenRepository.save(signin_Token);
    }
}
