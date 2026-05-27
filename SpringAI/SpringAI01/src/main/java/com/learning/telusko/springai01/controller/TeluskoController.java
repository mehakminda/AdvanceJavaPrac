package com.learning.telusko.springai01.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeluskoController {

   // @Autowired  or constructor injection
    private OpenAiChatModel chatModel;

    private ChatClient chatClient;

    private ChatClient chatClient2; // which has memory
    ChatMemory chatMemory = MessageWindowChatMemory.builder().build();

    private TeluskoController(OpenAiChatModel chatModel , ChatClient.Builder builder){
        this.chatModel = chatModel;
        this.chatClient = ChatClient.create(chatModel);
       this.chatClient2 = builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
    }
    //method1 : using chatmodel
    @GetMapping("/api/answer/{message}")
    public String getAnswer(@PathVariable String message){
        String response  = chatModel.call(message);
        return response;
    }


    //method2: chat client
    @GetMapping("/api/answer2/{message}")
    public ResponseEntity getAnswer2(@PathVariable String message){
        String response  = chatClient.prompt(message).call().content();//just body ie content
        // but we can get more like header,metadata etc....

        //return new ResponseEntity<>(response, HttpStatus.OK); //from openapi import
        //or
        return   ResponseEntity.ok(response); //from spring framework import
    }


    //method2: chat client, get more from response not just body
    @GetMapping("/api/answer3/{message}")
    public ResponseEntity getAnswer3(@PathVariable String message){
        ChatResponse chatResponse = chatClient.prompt(message).call().chatResponse();
        String response = chatResponse.getResult().getOutput().getText();

        System.out.println(chatResponse.getMetadata().getModel()); //model the chatcient is using

        return ResponseEntity.ok(response);
    }


    //Above did not have memory (making conversation stateful)
    //to get memory we have to provide memory using memoryAdvisor
    //Add Memory advisor to our chatClient

    //method2: chat client, with memory
    @GetMapping("/api/answer4/{message}")
    public ResponseEntity getAnswer4(@PathVariable String message){
        ChatResponse chatResponse = chatClient2.prompt(message)
                .call()
                .chatResponse();
        String response = chatResponse.getResult().getOutput().getText();

        System.out.println(chatResponse.getMetadata().getModel()); //model the chatclient is using

        return ResponseEntity.ok(response);
    }
}
/**
 * In Spring AI, ChatClient is a high-level, fluent API designed for building applications,
 * while ChatModel is a low-level interface that directly interacts with AI models.
 * ChatClient acts as a wrapper around ChatModel,
 * handling complex tasks like prompting, state management, and advisor integration.
 *
 *
 * just like hibernate vs spring datajpa
 */

/**
 * what are the other types of advisors?
 * memory/ retry/
 * something which is send to ai api with some advicesss..
 *
 * MessageChatMemoryAdvisor (for structured histories), PromptChatMemoryAdvisor (for condensed text), and VectorStoreChatMemoryAdvisor (for semantic, long-term recall).
 * what is the difference between langchain and spring ai, is langchain part of spring ai?
 *  langchain is for python
 *  langchain4j is for java
 *
 *  to implement langchain we need not using spring/apring ai. with normal java also we can do.
 *
 *
 *
 * */