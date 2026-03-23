package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class QueryController {

    @GetMapping("/getmessage")
    public String displayMessage(@RequestParam("namekey") String name, Map<String, Object> model){
        String msg="Hello! "+name+", I hope you are enjoying the course";
        model.put("msg",msg);
        return "index";
    } //test : localhost:8080/getmessage?namekey=mehak -> url +data

    @GetMapping("/getmessage2")
    public String displayMessage2( String name, Map<String, Object> model){ //Removing @RequestParam annotation
        String msg="Hello! "+name+", I hope you are enjoying the course";
        model.put("msg",msg);
        return "index";
    } //test : localhost:8080/getmessage2?name=mehak -> url +data
    //test : localhost:8080/getmessage2?namekey=mehak -> url +data -> namekey value is not passed to name, hence we get null.  The string variable name and queryParams key mismatch
    //o/p: Hello! null, I hope you are enjoying the course
    //Expected queryParameter name was name(String variable name) but got namekey

    //2 queryParams
    @GetMapping("/getmessage3")
    public String displayMessage3( String name, String course, Map<String, Object> model){ //Removing @RequestParam annotation
        String msg="Hello! "+name+", I hope you are enjoying the course "+course;
        model.put("msg",msg);
        return "index";
    } //test : localhost:8080/getmessage3?name=mehak&course=Java -> url +data
}

//sending data from view to controller

//localhost:8080/getmessage : this url will make the dispatcher servlet to map  this http request to this controller method


// Try name having space or special characters:

