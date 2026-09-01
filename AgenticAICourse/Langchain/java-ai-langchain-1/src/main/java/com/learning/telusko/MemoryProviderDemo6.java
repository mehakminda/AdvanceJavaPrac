package com.learning.telusko;


//ChatMemory for user using ChatMemoryProvider


import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public class MemoryProviderDemo6 {

    interface Assistant{

        @SystemMessage("You are Telusko Bot. Answer in one short sentence")
        String chat(@MemoryId String userId, @UserMessage String message);



    }

    static void main() {

       /* ChatMemoryProvider provider = memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(10)
                .build();*/
        //or we can pass this provider in chatMemoryProvider

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(Models.chat())
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .maxMessages(10)
                        .build())
                .build();

        System.out.println("============================");
        assistant.chat("Vyomi","My fav is Mehak Bua");
        assistant.chat("Mehak","My fav is Vyomi Minda");

        System.out.println("Vyomi: "+ assistant.chat("Vyomi", "Who is my fav"));
        System.out.println("Mehak: "+ assistant.chat("Mehak", "Who is my fav"));
        System.out.println("Jalaj: "+ assistant.chat("Jalaj", "Who is my fav"));


        //each user will have their own chat memory
        //mehak and vyomi had their chat memory in history but jalaj's memory was not there


        //On restart, chat context will be los => therefore, use chat memory store
    }
}

