package com.learning.telusko.springsecurity05.dao;


import com.learning.telusko.springsecurity05.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
