package com.learning.embark.kafkaproducer2;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaProducer2 {

    private final KafkaTemplate<String,RiderLocation> kafkaTemplate;

    public KafkaProducer2(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/sendObject")
    public String send2(@RequestParam  String message){
        RiderLocation location = new RiderLocation("rider123",28.2,61.33);
        //kafkaTemplate.send("my-topic-new",location); //we will get classcaste exception
        //we need to serialize this object to send to the consumer.
        // added key-serializer, value-serializer  in application.yml

        kafkaTemplate.send("my-topic-new",location);
        return "Message sent: " +location.getRiderId();
    }
}


/**
 * Sending/Receiving objects instead of string message to kafka
 */
