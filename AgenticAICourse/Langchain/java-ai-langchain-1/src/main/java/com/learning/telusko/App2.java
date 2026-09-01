package com.learning.telusko;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.time.Duration;
import java.util.Scanner;

public class App2 {
    static void main() {

        ChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName("gpt-4o-mini")
                .temperature(0.8)
                .timeout(Duration.ofSeconds(30))
                .build();

        MessageWindowChatMemory memory = MessageWindowChatMemory.withMaxMessages(20);
        memory.add(
                SystemMessage.from("You are helpful telukso bot, an assistant for java" +
                        "keep answers in 3 lines" +
                        " If you do not know something, say so")
        );

        Scanner sc= new Scanner(System.in);
        System.out.println("telusko bot is ready. Chat now. Also type 'exit' to quit");

        while(true){
            System.out.print("You: ");
            String input  = sc.nextLine();
            if("exit".equalsIgnoreCase(input.trim())){
                break;
            }
            memory.add(UserMessage.from(input));
            AiMessage aiMessage = chatModel.chat(memory.messages()).aiMessage();
            System.out.println("Bot : "+ aiMessage.text()+"\n");

            memory.add(aiMessage);
        }

        System.out.println("bye have a nice day");







    }
}
