package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/home")
    public String showHomePage(){
            return "home";
    }

    @GetMapping("/response")
    public String showResponse(Map<String,Object> model){

        String[] booksName= new String[]{"Java","Spring Boot","System Design"};
//        for(String book:booksName){
//            System.out.println(book);
//
//        }
        model.put("books",booksName);
        return "response";

    }
}

/**
 * We will make a call to the /home, home is rendered on view page.
 * when we click on the link, a /response url will be called
 *
 */

//send array data to view using jstl
//add jstl dependency in maven and jstl core library in jsp page