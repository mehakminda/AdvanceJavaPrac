package com.learning.telusko.service;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetingService implements  IGreetingService{
    @Override
    public String generateGreetings() {
        System.out.println("Control in service");
        LocalDateTime dateTime=LocalDateTime.now(); //juda api
        int hour=dateTime.getHour();
        if(hour<12) return "Good Morning!";
        else if(hour<20) return"Good afternoon!";
        else return "Good evening!";
    }
}
