package com.code.DoanJAVA.ServiceImpl;

import com.code.DoanJAVA.Repository.*;
import com.code.DoanJAVA.Service.accountService;
import com.code.DoanJAVA.Entity.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static com.code.DoanJAVA.Model.role.CLIENT;

@Service
public class accountServiceImpl implements accountService {

    @Autowired
    private accountRepository accountRepository;

    @Override
    public void save(account account) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setUserRole(CLIENT);
        accountRepository.save(account);
    }

    @Override
    public account getByUserName(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<account> getAll() {
        return accountRepository.findAll();
    }
}
