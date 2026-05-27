package com.learning.telusko.springai01.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TeluskoController3 {

    // @Autowired  or constructor injection
    private OpenAiChatModel chatModel;

    private ChatClient chatClient;

    @Autowired
    @Qualifier("openAiEmbeddingModel") //since we import from spring ai and not openai, hence many beans
    private EmbeddingModel embeddingModel;


    private TeluskoController3(OpenAiChatModel chatModel ){
        this.chatModel = chatModel;
        this.chatClient = ChatClient.create(chatModel);
    }


    @PostMapping("/api/embedding")
    public float[] recommend(@RequestParam String text ){
        return embeddingModel.embed(text);
    }


}
/**
 * embeddings
 *
 * similar to https://api.openai.com/v1/embeddings
 *
 *
 * */