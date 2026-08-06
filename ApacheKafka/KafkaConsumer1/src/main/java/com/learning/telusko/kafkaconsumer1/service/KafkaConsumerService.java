package com.learning.telusko.kafkaconsumer1.service;

import com.learning.telusko.kafkaconsumer1.model.Course;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    String message;

    @KafkaListener(topics="telusko" ,groupId = "telusko-CG")
    public void consume(Course course){

        message = course + " got the data from kafka";
        System.out.println(message);

    }

    public String getMessage() {
        return message;
    }
}
