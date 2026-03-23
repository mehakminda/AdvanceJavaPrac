package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ThirdController {

    @GetMapping("/alien")
    public String somMessage2(Map<String,Object> model){ //non invasive
        model.put("name","Mehak Alien");
        return "skill";  //logicalviewname

    }

    @GetMapping("/telusko")
    public void somInfo(Map<String,Object> model){ //non invasive
        model.put("name","Mehak Minda");
        return ;  //logicalviewname
//if the logical view name that we return is same as that of mapping, we can skip it, just make sure there is jsp file with the same name.
    }

    @GetMapping("/opentext")
    public String somMessage3(Map<String,Object> model){ //non invasive
        model.put("name","mminda");
        return "skill";  //logicalviewname

    }
}

/**
 * Model class behind the scene uses Map
 * Instead of Model class what if we use a Map
 */

//url <-> logical view name returned <-> jsp file name. (avoid using void return type)
//using map, model (better to use map)