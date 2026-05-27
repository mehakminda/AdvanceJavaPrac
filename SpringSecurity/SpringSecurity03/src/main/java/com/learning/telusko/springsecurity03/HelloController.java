package com.learning.telusko.springsecurity03;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello(HttpServletRequest request){
        return "Hello World " +request.getRequestedSessionId() ;
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
 * try from browser and from postman (use basic auth)
 *
 * client -> filters -> front controller(dispatcher servlet) -> controllers
 *
 * like how we have servlet filter.
 * client  -> servlet container - > filter 1 -> filter 2 -> filter 3  -> servlet
 * lets say filter1 deals with filter negative number in input
 * filter2 deals with location from where the request is coming.
 * once the request passes all the filters then the request will go to the actual servlet
 * this is called filter chain
 *
 *
 */

/**
 * how to send password securely
 *
 *
 */