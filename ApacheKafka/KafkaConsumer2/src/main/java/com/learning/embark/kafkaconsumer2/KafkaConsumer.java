package com.learning.embark.kafkaconsumer2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "test-group")
    public void listen1(String message){
        System.out.println("Received message in consumer1 :" +message);
    }

    @KafkaListener(topics = "my-topic", groupId = "test-group")
    public void listen2(String message){
        System.out.println("Received message in consumer2 :" +message);
    }

    @KafkaListener(topics = "my-topic-new", groupId = "rider-group")
    public void listen3RiderLocation(RiderLocation location){
        System.out.println("Received location :" +location.toString());
    }
    //listening to message which is an object
}
