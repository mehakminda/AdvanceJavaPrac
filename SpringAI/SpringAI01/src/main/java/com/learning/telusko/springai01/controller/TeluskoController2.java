package com.learning.telusko.springai01.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TeluskoController2 {

    // @Autowired  or constructor injection
    private OpenAiChatModel chatModel;

    private ChatClient chatClient;


    private TeluskoController2(OpenAiChatModel chatModel ){
        this.chatModel = chatModel;
        this.chatClient = ChatClient.create(chatModel);
    }


    @PostMapping("/api/recommend")
    public String recommend(@RequestParam String type, @RequestParam String year, @RequestParam String language ){
        String temp  = "";
        PromptTemplate promptTemplate = new PromptTemplate(temp);

        Prompt prompt = promptTemplate.create(Map.of(
                "type", type,
                "year", year,
                "language", language));
       String response =  chatClient.prompt(prompt)
               .call()
               .content();

        return response;
    }


}
/**
 * Prompt template
 *
 *
 * */