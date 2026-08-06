package com.learning.telusko.mcpserver2_math_server.config;


import com.learning.telusko.mcpserver2_math_server.tools.*;
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
            AdditionTool additionTool,
            ModulusTool modulusTool,
            MultiplicationTool multiplicationTool,
            PowerTool powerTool,
            SubtarctionTool subtarctionTool){

        return List.of(ToolCallbacks.from(additionTool,modulusTool,multiplicationTool,
                powerTool,subtarctionTool));
    }
}
