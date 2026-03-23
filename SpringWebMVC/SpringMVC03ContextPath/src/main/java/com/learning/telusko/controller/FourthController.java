package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/controller4")
public class FourthController {

    @GetMapping("/opentext")
    public String somMessage2(Map<String,Object> model){ //non invasive
        model.put("name","mminda controller4");
        return "skill";  //logicalviewname

    }

}
