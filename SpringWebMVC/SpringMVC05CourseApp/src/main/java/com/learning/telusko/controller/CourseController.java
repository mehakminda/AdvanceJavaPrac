package com.learning.telusko.controller;

import com.learning.telusko.pojo.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/greeting")
public class CourseController {


    @GetMapping("/coursedetails")
    public String getCourseDetails(Model model){
        System.out.println("In Container");
        model.addAttribute("cid","T1");
        model.addAttribute("cname","RestFul Services and Microservices");
        model.addAttribute("price","499 INR");
        model.addAttribute("courseDuration","6 months");
        return "course";
    }

    //Multiple Binding, passing course object to the view component
    @GetMapping({"/courseinfo","/course"})
    public String getCourseInfo(Model model) {
        Course course= new Course();
        course.setCid(1);
        course.setCname("Docker");
        course.setPrice(300.0);
        course.setCourseDuration("4 months");
        model.addAttribute("course",course);
        return "courseinfo";
    }

}

// Access : http://localhost:8080/CourseApp/coursedetails http://localhost:8080/CourseApp/courseinfo http://localhost:8080/CourseApp/course