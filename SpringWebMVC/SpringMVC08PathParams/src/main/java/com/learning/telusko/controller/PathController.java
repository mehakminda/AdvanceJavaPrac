package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PathController {


    @GetMapping("/getmessage/{name}/{course}")
    public String displayMessage(@PathVariable("name") String name, @PathVariable("course") String course, Map<String, Object> model ) {
        String msg = "Hello! "+name+ ", I hope you are enjoying the course "+course;
        model.put("msg", msg);
        return "index";

    } //test : localhost:8080/getmessage/mehak/java -> url +data

    @GetMapping("/getmessage2/{name}/{course}")
    public String displayMessage2(String name, String course, Map<String, Object> model ) { //Remove @PathVariable annotation
        String msg = "Hello! "+name+ ", I hope you are enjoying the course "+course;
        model.put("msg", msg);
        return "index";

    } //test : localhost:8080/getmessage2/mehak/java -> url +data ->got null for both name and course


    @GetMapping("/getmessage3/{namekey}/{course}")
    public String displayMessage3(@PathVariable("namekey") String name, String course, Map<String, Object> model ) { //Remove @PathVariable annotation
        String msg = "Hello! "+name+ ", I hope you are enjoying the course "+course;
        model.put("msg", msg);
        return "index";

    } //test : localhost:8080/getmessage3/mehak/java -> url +data -> got null for course
}

/**
 * path Params vs query Params
 *We can give path params anywhere in url, while query Params is always at the end.
 * path params uses only data and not key-value pair
 *
 *
 */
