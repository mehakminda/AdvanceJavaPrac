package com.learning.telusko.beans;

import org.springframework.stereotype.Component;

@Component(value="springBoot")
public class SpringBoot implements Course {
    public SpringBoot(){
        System.out.println("SpringBoot bean created");
    }
    @Override
    public boolean selectCourse(double amount) {
        System.out.println("Spring Boot course is selected and the fees paid is: "+amount);
        return true;
    }
}
