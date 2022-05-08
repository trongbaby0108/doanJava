package com.code.DoanJAVA.ServiceImpl;


import com.code.DoanJAVA.Entity.detail_Bill;
import com.code.DoanJAVA.Repository.detail_BillRepository;
import com.code.DoanJAVA.Service.detail_BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class detail_BilllServiceImpl implements detail_BillService {
    @Autowired
    private detail_BillRepository detail_billRepository;

    @Override
    public void save(detail_Bill detail_bill) {
        detail_billRepository.save(detail_bill);
    }
}
