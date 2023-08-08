package com.ozgurokan.fatura.dao;


import com.ozgurokan.fatura.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Integer> {


    public List<Bill> findBillByAccountId(String code);



}
