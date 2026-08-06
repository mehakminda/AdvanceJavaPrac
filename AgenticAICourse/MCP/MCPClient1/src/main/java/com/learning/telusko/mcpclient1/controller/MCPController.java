package com.learning.telusko.mcpclient1.controller;


import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.client.ChatClient;

@RestController
@RequestMapping("/mcp/api")
public class MCPController {

    private ChatClient chatClient;

    public MCPController(ChatClient.Builder chatclientBuilder, ToolCallbackProvider toolCallbackProvider){

        this.chatClient = chatclientBuilder.defaultToolCallbacks(toolCallbackProvider).build();

    }
    //Spring AI automatically creates MCP client during application startup

    @GetMapping("/chat")
    public String getAnswersMCP(@RequestParam String query ){
        return chatClient
                .prompt(query)
                .call()
                .content();
    }


}

/**
 * This is a way to use file system MCP Server which is in built in spring AI
 */

