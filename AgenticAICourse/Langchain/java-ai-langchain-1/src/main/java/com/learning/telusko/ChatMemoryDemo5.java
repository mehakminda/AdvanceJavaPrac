package com.learning.telusko;

import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiTokenCountEstimator;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;

public class ChatMemoryDemo5 {

    interface Assistant{

        @SystemMessage("You are Telusko's bot , answer in 1 short sentence")
        String chat(String message);

    }

    static void main() {


        //Messages limit

        /*System.out.println("--------------Message Window memory --------------");
       Assistant forgetful = AiServices.create(Assistant.class, Models.chat());
        System.out.println("Forgetful Bot: "+ forgetful.chat("My name is Navin Reddy"));
        System.out.println("Forgetful Bot: "+ forgetful.chat("What is my name"));
        System.out.println("----------------------------");


        Assistant withMemory = AiServices.builder(Assistant.class)
                .chatModel(Models.chat())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10)) // 10 messages
                .build();

        System.out.println("with Memory Bot: "+ withMemory.chat("My name is Navin Reddy"));
        System.out.println("with Memory Bot: "+ withMemory.chat("What is my name"));
        System.out.println("----------------------------");



        Assistant shortMemory = AiServices.builder(Assistant.class)
                .chatModel(Models.chat())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(3)) //only 3 messages
                .build();

        System.out.println("with Memory Bot: "+ shortMemory.chat("My name is Mehak Minda"));
        System.out.println("with Memory Bot: "+ shortMemory.chat("I teach AI engineering"));
        System.out.println("with Memory Bot: "+ shortMemory.chat("I am the most loved person"));
        //System.out.println("with Memory Bot: "+ shortMemory.chat("I have a loving family"));
        System.out.println("with Memory Bot: "+ shortMemory.chat("What is my name?"));
        System.out.println("with Memory Bot: "+ shortMemory.chat("What so i teach?"));

        //System.out.println(" memory Stored : "+ small.messages().size());// check the small
        System.out.println("----------------------------");
        */


        //Token limit
        //token control is better than message control
        //production grade
        //(in messages) java  <- -> ja va (in tokens)

        System.out.println("--------------Token Window memory --------------");

        AiServices.builder(Assistant.class)
                .chatModel(Models.chat())
                .chatMemory(TokenWindowChatMemory.builder()
                        .maxTokens(300, new OpenAiTokenCountEstimator("gpt-4o-mini"))
                        .build())
                .build();

        //beyond 300 tokens it will not keep the tokens
        //it will delete the ai message and user message but not the tone of system message

        //who is managing memory , ai model or langchain? langchain.








    }
}
