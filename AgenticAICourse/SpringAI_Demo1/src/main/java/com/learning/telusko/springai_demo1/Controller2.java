package com.learning.telusko.springai_demo1;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

    private ChatClient chatClient;

    public Controller2(OpenAiChatModel model){
        this.chatClient = ChatClient.create(model) ;
    }

    @GetMapping("/info2/{prompt}")
    public String getInfo(@PathVariable String prompt){
        return chatClient.prompt(prompt).call().content();
    }

}
