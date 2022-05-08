package com.code.DoanJAVA.Service;

import com.code.DoanJAVA.Entity.account;

import java.util.List;

public interface accountService {
    public void save(account account);
    public account getByUserName(String username);

    public List<account> getAll();
}
