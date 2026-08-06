package com.learning.telusko.springai_demo1;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {
    private OpenAiChatModel model;

    public Controller1(OpenAiChatModel model){
        this.model = model;
    }

    @GetMapping("/info1/{prompt}")
    public String getInfo(@PathVariable String prompt){
        return model.call(prompt);
    }
}
