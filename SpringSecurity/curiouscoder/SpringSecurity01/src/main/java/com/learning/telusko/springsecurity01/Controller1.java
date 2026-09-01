package com.learning.telusko.springsecurity01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello World!";
    }

    @GetMapping("/hi")
    public String getHi(){
        return "Hi World!";
    }

    @GetMapping("/hey")
    public String getHey(){
        return "Hey World!";
    }
}
