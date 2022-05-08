package com.code.DoanJAVA.Service;

import com.code.DoanJAVA.Entity.token;

public interface tokenService {
    public token findByToken(String token);
    public void save(token signin_Token);
}
