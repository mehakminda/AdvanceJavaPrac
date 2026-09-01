package com.learning.telusko.springbootailangchain2.controller;

import com.learning.telusko.springbootailangchain2.lc4j.Assistant;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {



    private Assistant assistant;

    public ChatController(Assistant assistant){
        this.assistant = assistant;

    }

    @GetMapping("/ask")
    public String ask(@RequestParam("question")  String question){
        return assistant.chat(question);
    }

    public ChatResponse askMore(@RequestBody ChatRequest request){

    }

    public record chatRequest(String userId, String message){

    }

    public record chatResponse(String userId, String message){

    }

}
