package com.code.JavaProject.ServiceImpl;

import com.code.JavaProject.Entity.bill;
import com.code.JavaProject.Repository.billRepository;
import com.code.JavaProject.Service.billService;
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
    public List<bill> getByUser(String name) {
        List<bill> bills = getAll();
        List<bill> result = new ArrayList<>();
        for (bill bill: bills) {
            if(bill.getName().equals(name))
                result.add(bill);
        }
        return result;
    }


}
