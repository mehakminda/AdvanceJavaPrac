package com.learning.telusko.controller;

import com.learning.telusko.model.Implementors;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class ImplementorsController {

    @GetMapping("/register")
    public String responseHome(@ModelAttribute("impl2") Implementors impl){
        return "register";
    }


    //method2
    @PostMapping("/register")
    public String registerData1(Map<String, Object> map, @ModelAttribute("impl2") Implementors impl){
        //@ModelAttribute("impl") Implementors impl - hey look spring there is a form, map the field of that form with Implementor class object
        //Implementors class is a model class which has to be binded within our application
        System.out.println(impl.toString());
        map.put("regUser", impl);

        return "results";
    }
}

//Are we able to get the form data as a java object into our application
//Data binding : sending data from view to controller
//data rendering: sending data from controller to view

//Access: http://localhost:8080/implementors/register
//see bengaluru is by default present indicating that pojo to form data

//Using Spring Tag library to demonstrate bi-directional binding



