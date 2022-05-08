package com.code.JavaProject.Model;

import lombok.Data;

import java.util.List;

@Data
public class bill_model {
    List<detail_BillModel> detailList;
    String name;
    String address;
    String phone;
}
