package com.code.JavaProject.Service;

import com.code.JavaProject.Entity.googleAccount;

public interface googleAccountService {
    public void save(googleAccount googleAccount);
    public googleAccount get(String email);
    public void update(String email, String address, String phone);
}
