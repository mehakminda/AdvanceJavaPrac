package com.learning.telusko;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class GreetingController {
    public GreetingController() {
        System.out.println("Greeting controller bean created");
    }

    @GetMapping("/hello")
    public ResponseEntity generateGreeting(){
        String body= "Heyy, Queen Mehak, You are the best!";
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }

    @GetMapping("/hi")
    public ResponseEntity generateGreeting2(){
        String body= "Heyy, Queen Mehak, You are the CEO!";
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}
/*Constructor gets invoked when we create object
by default 1 bean is created during startup.

my rest client here is browser/postman
make 2-3 call to /hello  endpoint
observe that only 1 bean is created during start up and that is only used to serve all request.
we do not create new bean for every request.
scope of bean is singleton (ie) only one copy

In one rest controller class we can have multiple method binding to a http method, which clients can access

*/
