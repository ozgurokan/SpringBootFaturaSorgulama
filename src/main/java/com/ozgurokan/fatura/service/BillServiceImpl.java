package com.ozgurokan.fatura.service;


import com.ozgurokan.fatura.dao.BillRepository;
import com.ozgurokan.fatura.dao.UserRepository;
import com.ozgurokan.fatura.entity.Bill;
import com.ozgurokan.fatura.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;
    private UserRepository userRepository;

    @Autowired
    public BillServiceImpl(BillRepository theBillRepository, UserRepository theUserRepository) {
        billRepository = theBillRepository;
        userRepository = theUserRepository;
    }


    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> findByAccountId(String code) {
        return billRepository.findBillByAccountId(code);
    }

    @Override
    public Bill findById(int theId) {
        Optional<Bill> result = billRepository.findById(theId);
        Bill theBill = null;

        if (result.isPresent()) {
            theBill = result.get();
        } else {
            throw new RuntimeException("Not found bill id - " + theId);
        }
        return theBill;
    }


    @Override
    public void save(Bill theBill) {
        billRepository.save(theBill);
    }

    @Override
    public void deleteById(int theId) {
        billRepository.deleteById(theId);
    }

    @Override
    public void pay(int theId, String code) {
        Optional<Bill> result = billRepository.findById(theId);
        User theUser = userRepository.findUserByCode(code);

        Bill theBill = null;

        if (result.isPresent()) {
            theBill = result.get();

            if (theBill.getAmount() < theUser.getBalance()){
                if (theBill.getStatus().equals("unpaid")){

                    theBill.setStatus("paid");
                    theUser.setBalance(theUser.getBalance() - theBill.getAmount());
                    userRepository.save(theUser);
                    billRepository.save(theBill);
                }else{
                    throw new RuntimeException("The bill already paid");
                }
            } else {
                throw new RuntimeException("You don't have enough balance for the payment");
            }
        } else {
            throw new RuntimeException("Not found bill id: " + theId);

        }
    }

    @Override
    public void payCancel(int theId,String code) {

        Optional<Bill> result = billRepository.findById(theId);
        User theUser = userRepository.findUserByCode(code);

        Bill theBill = null;

        if (result.isPresent()) {
            theBill = result.get();

            if (theBill.getStatus().equals("paid")){

                theBill.setStatus("unpaid");
                theUser.setBalance(theUser.getBalance() + theBill.getAmount());
                userRepository.save(theUser);
                billRepository.save(theBill);

            } else {
                throw new RuntimeException("The Bill already unpaid");
            }
        } else {
            throw new RuntimeException("Not found bill id: " + theId);

        }
    }
}
