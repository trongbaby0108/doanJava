package com.code.DoanJAVA.ServiceImpl;

import com.code.DoanJAVA.Entity.bill;
import com.code.DoanJAVA.Repository.billRepository;
import com.code.DoanJAVA.Service.billService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class billServiceImpl implements billService {
    @Autowired
    private billRepository billRepository ;
    @Override
    public void save(bill bill) {
        billRepository.save(bill);
    }

    @Override
    public List<bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public List<bill> getByUser(String username) {
        List<bill> bills = getAll();
        List<bill> result = new ArrayList<>();
        for (bill bill: bills) {
            if(bill.getAccount().getUsername().equals(username))
                result.add(bill);
        }
        return result;
    }


}
