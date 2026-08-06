package com.learning.telusko.springai_demo1;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

@Component
public class NewsTool {

    RestTemplate restTemplate = new RestTemplate();

    @Tool(description = "Get Latest news and current headlines")
    public String getLatestNews(String topic){

        System.out.println("News Tool");
        String apikey = "77b50211e751487ab034f0a30df87123";
        String url = "https://newsapi.org/v2/everything?q=" +topic + "&apiKey=" +apikey;
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;

    }
}
