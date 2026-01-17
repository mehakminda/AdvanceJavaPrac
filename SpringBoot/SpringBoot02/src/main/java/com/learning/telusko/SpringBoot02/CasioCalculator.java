package com.learning.telusko.SpringBoot02;

import org.springframework.stereotype.Service;

@Service
//@Component
public class CasioCalculator {
    public int add(int num1,int num2){
        return num1+num2;
    }

}
