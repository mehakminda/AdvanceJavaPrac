package com.learning.embark.kafkaproducer2;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaProducer {


    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("my-topic-new",message);
        return "Message sent: " + message;

    }
}

/***
 * there are 2 ways of doing dependency injection.
 * 1 @Autowired
 * 2.another constructor injection.
 *
 * When i am creating reference of KafkaTemplate and adding @Autowired why is it asking me to
 * add constructor.
 *
 * The issue is caused by using the final keyword on a field annotated with field-injection (@Autowired).
 * Java requires all final variables to be initialized during object construction,
 * which conflicts with Spring trying to inject the value after the object is created.
 */
