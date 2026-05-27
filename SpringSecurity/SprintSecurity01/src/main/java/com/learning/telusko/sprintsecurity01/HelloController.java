package com.learning.telusko.sprintsecurity01;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello World ";
    }

    @GetMapping("/about")
    public String aboutUs(){
        return "I am Mehak Minda";
    }
}

/**
 * adding spring security dependency we got the login form
 *
 * //by default the user name is 'user' and password is generated during startup
 *
 * we can set up username and password in application properties as well
 *
 *  try from browser and from postman (use basic auth)
 *
 */
