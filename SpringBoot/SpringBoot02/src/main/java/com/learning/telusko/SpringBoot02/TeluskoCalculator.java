package com.learning.telusko.SpringBoot02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeluskoCalculator {

    @Autowired
    CasioCalculator realCalc;


    public int add(int num1,int num2){
        return realCalc.add(num1,num2);
    }
}
