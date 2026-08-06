package com.learning.telusko.kafkaproducer1.controller;


import com.learning.telusko.kafkaproducer1.model.Course;
import com.learning.telusko.kafkaproducer1.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService service;

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        String response = service.sendMessage(course);
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }
}
