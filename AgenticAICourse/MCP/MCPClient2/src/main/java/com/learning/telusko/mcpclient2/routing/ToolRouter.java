package com.learning.telusko.mcpclient2.routing;


import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToolRouter {

    private List<McpSyncClient> mcpClients;

    private record ToolDef(String server, String toolName, List<String> keywords) {

        boolean matches(String lowerQuery) {
            return keywords.stream().anyMatch(lowerQuery::contains);
        }
    }


}
