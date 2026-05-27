package com.learning.telusko.springsecurity06.service;

import com.learning.telusko.springsecurity06.dao.UserRepo;
import com.learning.telusko.springsecurity06.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User saveuser(User user){
        return userRepo.save(user);
    }
}
