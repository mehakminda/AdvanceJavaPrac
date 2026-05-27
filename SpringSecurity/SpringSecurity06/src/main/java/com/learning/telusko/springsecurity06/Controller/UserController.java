package com.learning.telusko.springsecurity06.Controller;

import com.learning.telusko.springsecurity06.model.User;
import com.learning.telusko.springsecurity06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    public User register(@RequestBody User user){
        System.out.println("Adding user");
        return userService.saveuser(user);


    }
}

//user registeration