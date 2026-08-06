package com.learning.telusko.springai_demo1;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class Controller5 {

    private ChatClient chatClient;

    private ChatMemory chatMemory = MessageWindowChatMemory.builder().build(); //in-Memory chat memory

    private String conversationID = UUID.randomUUID().toString();

    @Autowired
    private DateTimeTool dateTimeTool;

    @Autowired
    private NewsTool newsTool;

    @Autowired
    private WeatherTool weatherTool;

    public Controller5(ChatClient.Builder builder){
        chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultAdvisors(a -> a.param(ChatMemory.CONVERSATION_ID,conversationID ))
                .build();
    }

    @GetMapping("/info5/{prompt}")
    public String getInfoWithTool(@PathVariable String prompt){
        ChatResponse chatResponse = chatClient.prompt(prompt)
                .tools(dateTimeTool,newsTool,weatherTool)
                .call().chatResponse();

        return chatResponse
                .getResult()
                .getOutput()
                .getText();
    }

    @GetMapping("/assitant/playMyDay/{prompt}")
    public String planMyDay(@PathVariable String prompt){
        return chatClient.prompt(prompt)
                .system("""
                       
                        You are a smart personal assistant.
                        
                        You have access to tools for date and time, weather, and latest news.
                        
                        Use whichever tools you need to answer the user clearly and completely.
                        
                        Always give a helpful, well-organized response.
                        """)//system prompt / setting  context/ setting tone of ai model
                .tools(dateTimeTool,newsTool,weatherTool)
                .call()
                .content();

    }
    @GetMapping("/recommend/movie")
    public String recommend(@RequestParam String type, @RequestParam String year, @RequestParam String lang){

        String tempPlate = """
                   I want to watch a {type} movie tonight with good rating,\\s
                   looking  for movies around this year {year}.\\s
                   The  language im looking for is {lang}.
                   Suggest one specific movie and tell me the cast and length of the movie.


                   response format should be:
                   1. Movie Name
                   2. basic plot
                   3. cast
                   4. length
                   5. IMDB rating
                """;
        PromptTemplate promptTemplate = new PromptTemplate(tempPlate);

        Prompt prompt = promptTemplate.create((Map.of(
                "type", type,
                "year", year,
                "lang", lang
        )));

        System.out.println(prompt.toString());
        String response = chatClient.prompt(prompt).call().content();

        return response ;

    }
}
/**
 * We will not invoke tools or tell whether to call tool or not , when to call tool.
 * The ai model will decide whether to call tool or not and which tool to call based on multiple tools
 * if available
 */