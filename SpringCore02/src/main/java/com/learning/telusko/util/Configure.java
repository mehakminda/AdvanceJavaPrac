package com.learning.telusko.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {
    public Configure(){
        System.out.println("Configure obj is created");
    }

    @Bean
    public void GenerateAlgo(){
        Password p=new Password("SHA1");
    }
    /*
    * This wont work on spring 6 version: Configuration problem: @Bean method 'GenerateAlgo' must not be declared as void; change the method's return type or its annotation.
    *
    * You don't as that doesn't make sense and as such is now forbidden in newer Spring versions
    *
    * There is no other way as using @Bean on void methods doesn't make sense (what is a void bean? ). This is abusing the @Bean to do some initializing callback,
    * for which you should use other means. What you need to change is already included in the message, so tell your 3rd party provider to fix their code or don't
    * use their configuration but copy it and fix it yourself.*/

}
