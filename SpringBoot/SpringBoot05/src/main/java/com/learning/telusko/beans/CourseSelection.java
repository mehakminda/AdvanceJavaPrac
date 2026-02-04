package com.learning.telusko.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

//This class is using the services of other classes
@Component(value="courseSelection")
public class CourseSelection {
    @Autowired
    LocalTime time;

    @Autowired
    Map<String, Course> courses; // all Course beans (key = bean name)

    // Keep the old field-based injection behaviour for compatibility by delegating
    @Autowired(required = false)
    @Qualifier("java")
    Course course; // kept only for backward compatibility if present

    /*here we are passing qualifier java, but what if we want the user's input. How to we inject to the course field using the user input??*/

    // Original method (keeps previous behavior)
    public boolean chooseCouse(double amount){
        System.out.println("Time is: "+time);
        if(course == null){
            System.out.println("Default course bean not available; try runtime selection instead.");
            return false;
        }
        return course.selectCourse(amount);
    }

    // New method: choose a course at runtime using the bean name (e.g. "java", "hibernate", "springBoot")
    public boolean chooseCouse(String courseBeanName, double amount){
        System.out.println("Time is: "+time);
        if(courseBeanName == null){
            System.out.println("No course name provided");
            return false;
        }
        // try exact match first
        Course chosen = courses.get(courseBeanName);
        if(chosen == null){
            // try case-insensitive match
            for(Map.Entry<String, Course> e : courses.entrySet()){
                if(e.getKey().equalsIgnoreCase(courseBeanName)){
                    chosen = e.getValue();
                    break;
                }
            }
        }
        if(chosen == null){
            System.out.println("Course '"+courseBeanName+"' not found. Available: "+courses.keySet());
            return false;
        }
        return chosen.selectCourse(amount);
    }

    public CourseSelection(){
        System.out.println("CourseSelection bean is created");
    }


}
