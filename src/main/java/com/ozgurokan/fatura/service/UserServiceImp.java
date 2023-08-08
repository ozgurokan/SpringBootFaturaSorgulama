package com.ozgurokan.fatura.service;

import com.ozgurokan.fatura.dao.UserRepository;
import com.ozgurokan.fatura.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {

        Optional<User> result = userRepository.findById(theId);
        User theUser = null;

        if(result.isPresent()){
            theUser = result.get();

        }else{
            throw new RuntimeException("Did not find User id - "+ theId);
        }

        return theUser;
    }

    @Override
    public User findUserByCode(String code) {
        return userRepository.findUserByCode(code);
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }
}
