package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
    @RequestMapping("/welcome")
    public String somMessage(Model model){
        System.out.println("Model class is implemented by : "+model.getClass().getName());
        model.addAttribute("name","Mehak");
        return "home";  //logicalviewname
    }

    @GetMapping("/welcome2")
    public String somMessage2(Model model){

        System.out.println("Model class is implemented by : "+model.getClass().getName());
        model.addAttribute("name","Mehak2");
        return "home";  //logicalviewname

    }

@GetMapping("/skill")
public String somImportantMsg(Model model){
    System.out.println("Model class is implemented by : "+model.getClass().getName());
    model.addAttribute("name","Mehak2");
    return "skill";  //logicalviewname

}

}

//Spring application runs on embedded tomcat server
//each spring application has its own embedded tomcat server and runs on it.


//in real time one server will have multiple applications.
//hence, we need context path inorder to give each application a sepcific url thereby avoiding url redundancy and collision
//localhost:8080/app1/focus , loclhost:8080/app2/focus, both these focus are doing different thing as they come from different application


//Access this application url as : http://localhost:8080/myapp/skill , http://localhost:8080/myapp/controller4/opentext






