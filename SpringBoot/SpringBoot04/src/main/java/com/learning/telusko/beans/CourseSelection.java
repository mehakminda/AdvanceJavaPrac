package com.learning.telusko.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

//This class is using the services of other classes
@Component(value="courseSelection")
public class CourseSelection {
    @Autowired
    LocalTime time;

    @Autowired
    @Qualifier("java")
     Course course; // 3 objects are available that can be injected..ambiguity..
    /*here we are passing qualifier java, but what if we want the user's input. How to we inject to the course field using the user input?? next project*/


    public boolean chooseCouse(double amount){
        System.out.println("Time is: "+time);
        return course.selectCourse(amount);
    }


    public CourseSelection(){
        System.out.println("CourseSelection bean is created");
    }


}
