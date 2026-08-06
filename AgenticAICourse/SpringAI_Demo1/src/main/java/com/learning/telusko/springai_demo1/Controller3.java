package com.learning.telusko.springai_demo1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller3 {
    private ChatClient chatClient;

    public Controller3(ChatClient.Builder builder){
        chatClient = builder.build();
    }

    @GetMapping("/info3/{prompt}")
    public String getInfo(@PathVariable String prompt){
        return chatClient.prompt(prompt).call().content();
    }
}

/***
 * Based on builder design pattern
 */