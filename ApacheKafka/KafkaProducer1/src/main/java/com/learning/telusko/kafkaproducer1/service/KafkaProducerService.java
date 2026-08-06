package com.learning.telusko.kafkaproducer1.service;

import com.learning.telusko.kafkaproducer1.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Course> kafkaTemplate;

    public String sendMessage(Course course){

        kafkaTemplate.send("telusko", "course",course);
        //completable future is async calls
        return "Course sent to kafka server";
    }
}
