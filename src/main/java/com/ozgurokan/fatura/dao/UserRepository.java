package com.ozgurokan.fatura.dao;

import com.ozgurokan.fatura.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {


    public User findUserByCode(String code);


}
