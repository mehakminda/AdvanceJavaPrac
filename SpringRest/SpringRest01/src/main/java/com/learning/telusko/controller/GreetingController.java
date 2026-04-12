package com.learning.telusko.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//@Controller
@RestController //@Controller + @ResponseBody
public class GreetingController {

    @GetMapping("/api1")
    //@ResponseBody //we specify this as return type is not logical view name
    public ResponseEntity generateGreeting(){
        LocalDateTime dateTime =LocalDateTime.now();

        int hour= dateTime.getHour();
        String body=null;
        if(hour<12) body = "Good Morning!";
        else if(hour <16) body = "Good Afternoon";
        else if(hour<20) body = "Good Evening";
        else body="Good Night";

        return new ResponseEntity<String>(body, HttpStatus.OK);
        //return body of type string
    }

}

/*
Testing: Access http://localhost:8080/api1 in browser or postman
my rest client here is browser/postman


why are we returning ResponseEntity object?

1. @Controller + @ResponseBody
2. @RestController
(we can use either of two)


 */