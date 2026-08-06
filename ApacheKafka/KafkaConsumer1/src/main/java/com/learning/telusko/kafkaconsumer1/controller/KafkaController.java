package com.learning.telusko.kafkaconsumer1.controller;


import com.learning.telusko.kafkaconsumer1.model.Course;
import com.learning.telusko.kafkaconsumer1.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaConsumerService service;

    @GetMapping("/getCourse")
    public ResponseEntity<String> addCourse(){
        String response = service.getMessage();
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }
}
