package com.learning.telusko.mcpserver1.tools;


import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
public class NewsTool {

    @Value("${news.api.key")
    private String apiKey;

    private RestTemplate restTemplate = new RestTemplate();

    @Tool(description = "Get the current news headlines for a specific topic or keyword." +
            "Use this when user asks about news, current events or recent updates on any subject")
    public String  getNews(@ToolParam(description="Topic or keyword to search news for " +
            "such as 'AI','India','technology'") String topic){

        String url = "https://newsapi.org/v2/everything?q="+topic.replace("","+")
                +"&pageSize=5&sortBy=publishedAt&apiKey="+apiKey;

        try{
            String result = restTemplate.getForObject(url,String.class);
            return result != null ? result : " No news found for the topic "+topic;
        }
        catch(Exception e){
            return "Error in fetch news API" + e.getMessage();
        }



    }



}


