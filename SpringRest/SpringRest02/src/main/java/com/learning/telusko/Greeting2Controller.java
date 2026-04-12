package com.learning.telusko;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/params")
public class Greeting2Controller {
    public Greeting2Controller() {
        System.out.println("Greeting controller2 bean created");
    }

    //query params
    @GetMapping("/hello")
    public ResponseEntity generateGreeting(@RequestParam(value="name1", required=true, defaultValue="Chinna") String name){ //specifying name1 is optional
        String body= "Heyy, Queen "+name+", You are the best! from Params";
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }

    //path Params
    @GetMapping("/hi/{name1}")
    public ResponseEntity generateGreeting2(@PathVariable(value="name1") String name){
        String body= "Heyy, Queen "+name+", You are the CEO! from Params";
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}

/*

localhost:8080/params/hello?name1=Mehak -> query parameter
localhost:8080/params/hi/Mehak - path parameter

Ways of writing query Params:
@RequestParam("name1") //has only 1 attribute ie name, if we have only 1 attribute we can skip writing value
@RequestParam(value="name1")
@RequestParam(value="name1", required=false)
@RequestParam(value="name1", required=true, defaultValue="Chinna")
 */
