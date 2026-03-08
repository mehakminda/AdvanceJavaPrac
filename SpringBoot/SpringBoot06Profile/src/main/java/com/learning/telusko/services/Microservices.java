package com.learning.telusko.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Primary //qualifier can also be used alternatively
@Profile("microservice")
public class Microservices implements Courses{
    @Override
    public boolean registerToCourses(Double cost) {
        System.out.println("Registered to course Microservices services and amount paid is "+cost);
        return true;
    }
}
