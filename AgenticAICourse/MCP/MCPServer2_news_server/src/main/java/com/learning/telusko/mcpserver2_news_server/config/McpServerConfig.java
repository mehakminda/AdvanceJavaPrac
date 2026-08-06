package com.learning.telusko.mcpserver2_news_server.config;


import com.learning.telusko.mcpserver2_news_server.tools.NewsByCategory;
import com.learning.telusko.mcpserver2_news_server.tools.NewsSearchTool;
import com.learning.telusko.mcpserver2_news_server.tools.TopHeadLinesTool;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class McpServerConfig {


    //Each tool lives in its own class. The news-server exposes 3 separate tools
    @Bean
    public List<ToolCallback> toolCallbackList(
            NewsByCategory newsByCategory,
            NewsSearchTool newsSearchTool,
            TopHeadLinesTool topHeadLinesTool){

        return List.of(ToolCallbacks.from(newsByCategory,newsSearchTool,topHeadLinesTool));
    }
}
