package com.learning.telusko.mcpserver1.configuration;


import com.learning.telusko.mcpserver1.tools.CalculatorTool;
import com.learning.telusko.mcpserver1.tools.DateTimeTool;
import com.learning.telusko.mcpserver1.tools.NewsTool;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class McpServerConfig {

    @Bean
    public List<ToolCallback> toolCallbackList(
            DateTimeTool dateTimeTool,
            NewsTool newsTool,
            CalculatorTool calculatorTool){

        return List.of(ToolCallbacks.from(dateTimeTool,newsTool,calculatorTool));
    }
}
