package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/skill")
    public String somMessage2(Model model){

        System.out.println("Model class is implemented by : "+model.getClass().getName());
        model.addAttribute("name","Mehak2");
        return "skill";  //logicalviewname

    }
}
/**
 * If we give same  url mapping and same http method in 2 different class, we get error like:
 * com.learning.telusko.controller.SecondController#somMessage2(Model)
 * to {GET [/skill]}: There is already 'firstController' bean method
 *
 * but with different http method works
 */