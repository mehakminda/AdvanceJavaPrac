package com.learning.telusko.springai_demo2;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat-memory")
public class ChatMemoryController1 {

    private final ChatClient chatClient;


    public ChatMemoryController1(ChatClient.Builder builder, JdbcChatMemoryRepository jdbcChatMemoryRepository){
        ChatMemory chatMemory  = MessageWindowChatMemory.builder()
                .chatMemoryRepository(jdbcChatMemoryRepository).maxMessages(20).build();
        this.chatClient = builder.defaultSystem(
                """
                        You are Telusko's friendly AI assistant.
                        Answer clearly, keep responses helpful, and remember what the user tells you.
                """
        ).defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();

    }
    @GetMapping("/chat")
    public String chatWithMemory(@RequestParam  String userID, @RequestParam String prompt){
        return chatClient.prompt(prompt).advisors(a-> a.param(ChatMemory.CONVERSATION_ID,userID)).call().content();

    }



}

/**
 *
 * MessageWindowChatMemory is a concrete memory storage implementation,
 * MessageChatMemoryAdvisor is an interceptor (advisor) component that retrieves that stored memory and injects it into your LLM prompt. They are designed to work together to manage conversation context.
 */
/**
 * Table in database with name spring_ai_chat_memory got created because of the settings:
 * spring.ai.chat.memory.repository.jdbc.initialize-schema=always
 *
 */
/***
 * default advisors like default security filter
 * filters and interceptors
 *  filters -> dispatcherServlet -> interceptor
 */
