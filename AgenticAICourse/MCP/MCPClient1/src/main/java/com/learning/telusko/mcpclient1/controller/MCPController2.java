package com.learning.telusko.mcpclient1.controller;


import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.client.ChatClient;

@RestController
@RequestMapping("/mcp/api2")
public class MCPController2 {

    private ChatClient chatClient;

    public MCPController2(ChatClient.Builder chatclientBuilder, ToolCallbackProvider toolCallbackProvider){

        this.chatClient = chatclientBuilder
                .defaultSystem("""
                        """)
                .defaultToolCallbacks(toolCallbackProvider).build();

    }
    //Spring AI automatically creates MCP client during application startup

    @GetMapping("/chat2")
    public String getAnswersMCP(@RequestParam String query ){
        return chatClient
                .prompt(query)
                .call()
                .content();
    }


    @GetMapping("/chat2-custom")
    public String getAnswers(@RequestParam String query ){
        return chatClient
                .prompt(query)
                .call()
                .content();
    }


}

/**
 * Here we are creating chat client in such a way that ot takes both built in file System MCP server
 * and  the custom MCP Server (MCPServer1 -> project)
 *
 *
 * Host will create 2 clients here. one for file system MCP and 1 for custom MCPserver1 MCP server
 *
 * We do not create client . its spring Ai who will create client based on the properties mentioned in
 * application.properties
 *
 * spring.ai.mcp.client.stdio.servers-configuration=classpath:mcp-servers.json
 * spring.ai.mcp.client.sse.connections.MCPServer1.url=hhtp://localhost:8484
 */

