package com.learning.telusko.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class Configure {
    @Bean
    public LocalTime createTimeBean(){
        return LocalTime.now();
    }
}
