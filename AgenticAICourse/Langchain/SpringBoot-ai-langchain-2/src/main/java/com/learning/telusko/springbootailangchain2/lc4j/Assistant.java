package com.learning.telusko.springbootailangchain2.lc4j;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Assistant {

    @SystemMessage(""" 
                You are helpful assistant for Java and spring boot training company
                Answer in at most three sentences.
                If the question i snot about programming, politely refuse
                """)
    String chat( String userMessage);


    @SystemMessage("You are Telusko Bot. Answer in one short sentence")
    String chat(@MemoryId String userId, @UserMessage String message);

    @SystemMessage("You are a strict but encouraging Java reviewer")
    @UserMessage("""
            Review the {{language}} for {level}} developer
            
            
            ```
            {{code}}
            ```
            
            """)
    String codeReview(@V("language") String language,
                      @V("level") String level,
                      @V("code") String code);

}
