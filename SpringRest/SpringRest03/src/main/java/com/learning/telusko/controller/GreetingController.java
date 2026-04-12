package com.learning.telusko.controller;

import com.learning.telusko.pojo.Implementer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

    @GetMapping("/implementerInfo")
    public Implementer generateGreeting(){
        Implementer impl = new Implementer();
        impl.setId(1);
        impl.setName("Mehak");
        impl.setCity("USA");
        return impl;
    }

    @GetMapping("/hi")
    public ResponseEntity generateGreeting2(){
        String body= "Heyy, Queen Mehak, You are the CEO!";
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}


/**
 * localhost:8080/api/implementerInfo
 *
 * {
 *     "city": "USA",
 *     "id": 1,
 *     "name": "Mehak"
 * }
 *
 * java object in json form is returned to the rest client
 *
 * This is done by Jackson, and jackson api we ddint add
 * we added only spring boot starter and spring web dependency , so from where did jackson come?
 * it comes from spring internally
 *
 * jackson api is a json parser, that converts java object -> json(vide versa)
 *
 * JSON: javascript object notation
 * compared to xml jason is light wieght.
 */

/**
 * http get request is idempotent
 * doesnt impact application
 */