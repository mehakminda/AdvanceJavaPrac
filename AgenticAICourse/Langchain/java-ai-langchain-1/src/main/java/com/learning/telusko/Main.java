package com.learning.telusko;


import dev.langchain4j.model.openai.OpenAiChatModel;

import java.time.Duration;


public class Main {
    static void main() {

        System.out.println("Hello and welcome to telusko");

/*        ChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName("gpt-4o-mini")
                .build();
//        String response  = chatModel.chat("Hi, Tell me about Langchain4j in short");
//        System.out.println(response);

        SystemMessage systemMessage = SystemMessage.from(
                "You are a java trainer at Telusko. Answer in short bullet point");
        UserMessage userMessage = UserMessage.from("Hi, tell me why do we need interface");

        ChatResponse response =chatModel.chat(systemMessage, userMessage);
        AiMessage reply = response.aiMessage();
        System.out.println("Answer: "+reply);
        System.out.println("Model used: "+response.modelName());
        System.out.println("Total token  used: "+response.tokenUsage().totalTokenCount());
        System.out.println("Total input token  used: "+response.tokenUsage().inputTokenCount());
        System.out.println("Total output token  used: "+response.tokenUsage().outputTokenCount());

        System.out.println("Finish reason: "+ response.metadata().finishReason());


        System.out.println("-----------------------------------------------------");*/

/*        List<ChatMessage> conversation = new ArrayList<>();
        conversation.add(SystemMessage.from("You are helpful assitant . Keep answers to one line"));
        conversation.add(UserMessage.from("My name is navin and i teach java"));

        AiMessage aiMessage = chatModel.chat(conversation).aiMessage();

        System.out.println("First message Answer: "+aiMessage.text());


        conversation.add(aiMessage);

        conversation.add(UserMessage.from("What do i teach?"));

       AiMessage aiMessage2= chatModel.chat(conversation).aiMessage();
        System.out.println("Second message : "+aiMessage2.text());

        conversation.add(aiMessage2);

        conversation.add(UserMessage.from("I also teach spring boot and ai engineering"));

        AiMessage aiMessage3= chatModel.chat(conversation).aiMessage();
        System.out.println("Third message : "+aiMessage3.text());

        conversation.add(aiMessage3);

        conversation.add(UserMessage.from("what do i teach?"));

        AiMessage aiMessage4= chatModel.chat(conversation).aiMessage();
        System.out.println("Fourth message : "+aiMessage4.text());*/


 /*       OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName("gpt-4o-mini")
                .temperature(0.7)
                .build();

        ChatRequest chatRequest = ChatRequest.builder()
                .messages(UserMessage.from("Give me the exact SQL to create a users table with id, email and created_at"))
                .modelName("gpt-4o")
                .temperature(0.0)
                .maxOutputTokens(150)
                .build();

        ChatResponse response = chatModel.chat(chatRequest);
        System.out.println(response.aiMessage().text());
        System.out.println(response.modelName());

        for(int i= 1; i < 4; i++){
            System.out.println(chatModel.chat(i+" : "+ "Give me one tagline for Java Training company. Only the tagline"));
        }*/



        OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                //.messages(UserMessage.from("Give me the exact SQL to create a users table with id, email and created_at"))
                .modelName("gpt-4o")
                //control creativity (0.0 -> 2.0)
                .temperature(0.0)
                //helps control response length
                .maxCompletionTokens(500)
                //reduces repeated words (-2.0 -> 2.0)
                .frequencyPenalty(0.3)
                .presencePenalty(0.0)
                .stop(java.util.List.of("###"))
                .timeout(Duration.ofSeconds(30))
                .logRequests(true)
                .logResponses(true)
                .maxRetries(2)
                .build();

        for(int i= 1; i < 4; i++){
            System.out.println(chatModel.chat(i+" : "+ "Tell me in short about java"));
        }

    }
}


/**
 * Temperature:
 *
 *
 * 0.0 - exact
 * 0.5 - 0.8 - natural and human
 * >0.8 - creative or innovative
 *
 0.0: Fully deterministic and focused. The model picks the most probable next token, making responses predictable and factual.
 0.3 to 0.7: Balanced and conservative. Good for standard text tasks, summarization, or coding assistance.
 0.8 to 1.0+: Creative and random. Higher values introduce more diversity into the answers, which is useful for creative writing or brainstorming.
 (Values above 1.0 or up to 2.0 are supported by specific providers like OpenAI/Vertex AI, though extremely high numbers may cause the model to output unstructured garbage)
 */