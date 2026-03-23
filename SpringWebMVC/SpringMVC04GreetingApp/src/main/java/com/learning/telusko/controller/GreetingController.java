package com.learning.telusko.controller;

import com.learning.telusko.service.IGreetingService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    private IGreetingService iGreetingService;

    @GetMapping("/getwish")
    public void showResponse (Map<String, Object> model){
        System.out.println("Control in container");
        model.put("greet",iGreetingService.generateGreetings());
        return;
      //  return "getwish";
    }


    @GetMapping("/getwish1")
    public Map<String,Object> showResponse (){
        String greet =iGreetingService.generateGreetings();
        Map<String,Object> map=new HashMap<>();
        map.put("greet","greet");
        return map;
        //return type as map (earlier we have seen void and string)
    }

    @GetMapping("/getwish2")
    public void showResponse2 (HttpServletResponse response) throws IOException { //option is available but not recommended
        //In servlet we used to send response via HTTPServletResponse object, lets try to send data in that way
        //also makes it invasive, (if we use class or interface form any of the tecnology it makes the app invasive ie dependent)
        System.out.println("Control in container");
        String greet =iGreetingService.generateGreetings();
        PrintWriter writer=response.getWriter();
        writer.println("<h1>This is from controller directly,"+greet+" </h1>");

    }
}

// Access : http://localhost:8080/GreetApp/getwish, http://localhost:8080/GreetApp/getwish1, http://localhost:8080/GreetApp/getwish2