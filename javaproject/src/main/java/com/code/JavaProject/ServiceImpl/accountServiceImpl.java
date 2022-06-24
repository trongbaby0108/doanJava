package com.code.JavaProject.ServiceImpl;

import com.code.JavaProject.Service.accountService;
import com.code.JavaProject.Entity.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static com.code.JavaProject.Model.role.CLIENT;

@Service
public class accountServiceImpl implements accountService {

    @Autowired
    private com.code.JavaProject.Repository.accountRepository accountRepository;

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
