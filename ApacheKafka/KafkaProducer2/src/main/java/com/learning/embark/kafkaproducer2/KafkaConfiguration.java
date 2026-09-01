package com.learning.embark.kafkaproducer2;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic createMyTopic(){
        return new NewTopic("my-code-topic",3,(short)1);
    }
}


//create topics using java configuration
//or create topics using kafka cli