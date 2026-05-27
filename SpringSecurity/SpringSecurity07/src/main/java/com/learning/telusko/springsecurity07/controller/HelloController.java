package com.learning.telusko.springsecurity07.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello(HttpServletRequest request){
        return "Hello World " +request.getSession().getId() ;
    }
    @GetMapping("/about")
    public String aboutUs(HttpServletRequest request){
        return "I am Mehak Minda " +request.getSession().getId() ;
    }
}
