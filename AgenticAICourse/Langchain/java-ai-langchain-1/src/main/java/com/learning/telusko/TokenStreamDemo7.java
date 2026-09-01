package com.learning.telusko;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.TokenStream;

import java.util.concurrent.CountDownLatch;

public class TokenStreamDemo7 {

    interface  Assistant{

        @SystemMessage("You are Telusko Bot. Explain clearly with short paragraphs")
        TokenStream chat(String message);
    }

    static void main() throws InterruptedException {

        Assistant assistant = AiServices.builder(Assistant.class)
                .streamingChatModel(Models.streamingChat())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        TokenStream stream = assistant.chat("Tell a scenario based Kafka interview question");

        CountDownLatch done = new CountDownLatch(1);

        stream
                .onPartialResponse(System.out::print)
                .onCompleteResponse(chatResponse ->
                        System.out.println("\n \n Response completed \n "+ chatResponse.metadata().tokenUsage() ))

                //there are few more statements
                .onError(error ->
                        System.out.println("Error" + error.getMessage()))
                .start();

        done.await();

    }

}
