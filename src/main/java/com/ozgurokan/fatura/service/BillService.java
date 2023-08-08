package com.ozgurokan.fatura.service;

import com.ozgurokan.fatura.entity.Bill;
import com.ozgurokan.fatura.entity.User;

import java.util.List;

public interface BillService {

    List<Bill> findAll();

    List<Bill> findByAccountId(String code);

    Bill findById(int theId);

    void save(Bill theBill);

    void deleteById(int theId);

    void pay(int theId,String code);

    void payCancel(int theId,String code);


}
