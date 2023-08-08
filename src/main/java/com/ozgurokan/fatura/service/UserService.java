package com.ozgurokan.fatura.service;

import com.ozgurokan.fatura.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    User findUserByCode(String code);
    void save(User theUser);

    void deleteById(int theId);


}
