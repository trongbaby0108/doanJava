package com.code.JavaProject.Service;

import com.code.JavaProject.Entity.token;

public interface tokenService {
    public token findByToken(String token);
    public void save(token signin_Token);
}
