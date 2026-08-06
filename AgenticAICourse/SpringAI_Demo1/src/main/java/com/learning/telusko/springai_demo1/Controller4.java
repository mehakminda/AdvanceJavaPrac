package com.learning.telusko.springai_demo1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Controller4 {

    private ChatClient chatClient;

    private ChatMemory chatMemory = MessageWindowChatMemory.builder().build();

    private String conversationID = UUID.randomUUID().toString();

    public Controller4(ChatClient.Builder builder){
//        chatClient = builder
//                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
//                .build();
        chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultAdvisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationID))
                .build();
    }

    @GetMapping("/info4/{prompt}")
    public String getInfoWithMemory(@PathVariable String prompt){
        //return chatClient.prompt(prompt).call().content();
        ChatResponse chatResponse = chatClient.prompt(prompt).call().chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());
        return chatResponse.getResult().getOutput().getText();

    }
}
/**
 * conversation id is specific to user/session
 */
/**
 * by default : gpt-5-mini-2025-08-07 is the model been used, but we can configure it
 */


/***
 *
 * https://www.perplexity.ai/search/96604718-135f-4b85-86a9-7640fecc73ac ..**** very very good..must read
 *
 * What is an “advisor” in Spring AI?
 * An advisor is a component that can intercept and modify the chat interaction at various points:
 * before the request is sent, after the response comes back, or during tool calling / RAG / memory handling
 *
 * Eg: MessageChatMemoryAdvisor, ToolCallingAdvisor, StructuredOutputValidationAdvisor, QuestionAnswerAdvisor
 *
 *
 *  What does defaultAdvisors do?
 * There are two overloads you’ll see:
 * Builder defaultAdvisors(Advisor... advisors);
 * Builder defaultAdvisors(Consumer<AdvisorSpec> advisorSpecConsumer);
 *
 * defaultAdvisors(Advisor... advisors) – just register advisor instances directly.
 *
 * defaultAdvisors(Consumer<AdvisorSpec> advisorSpecConsumer) – configure advisors and their parameters in a more flexible way
 *
 * 3. What is AdvisorSpec?
 * AdvisorSpec is a small spec interface used only inside the advisors configuration DSL.
 *
 *
 * Why a Consumer<AdvisorSpec>?
 * Builder defaultAdvisors(Consumer<AdvisorSpec> advisorSpecConsumer);
 * This follows a common Spring / fluent-API pattern:
 *
 * 1. The framework creates a mutable AdvisorSpec implementation internally.
 * 2. It passes that instance into your lambda (advisorSpecConsumer).
 * 3. Inside the lambda, you call methods on AdvisorSpec to configure it.
 * 4. The builder then uses that configured spec to set up the default advisor chain.
 *
 *
 * eg 1: ChatClient chatClient = ChatClient.builder(chatModel)
 *     .defaultAdvisors(advisorSpec -> advisorSpec
 *         .advisors(
 *             MessageChatMemoryAdvisor.builder(chatMemory).build(),
 *             QuestionAnswerAdvisor.builder(vectorStore).build()
 *         )
 *         .param(ChatMemory.CONVERSATION_ID, "user-123")
 *         .param("maxMessages", 10)
 *     )
 *     .build();
 *
 *  eg 2:
 *  .defaultAdvisors(spec -> {
 *     spec.advisors(myAdvisor1, myAdvisor2);
 *     spec.param("conversationId", "abc");
 *     spec.params(Map.of("maxMessages", 5, "tenantId", "acme"));
 * });
 *
 *
 * 5. How does this differ from per-request .advisors(...)?
 *
 * You have two places to configure advisors:  At client-build time (defaults) , At request time (per-call overrides/additions)
 *
 * 1. At client-build time (defaults):
 * These advisors are always in the chain for every request from this chatClient, unless overridden.
 * Good for cross-cutting behavior: memory, RAG, tool calling, validation, logging, etc.
 *
 * eg: ChatClient chatClient = ChatClient.builder(chatModel)
 *     .defaultAdvisors(spec -> spec
 *         .advisors(memoryAdvisor, ragAdvisor)
 *         .param(ChatMemory.CONVERSATION_ID, "default-conversation")
 *     )
 *     .build();
 *
 * 2. At request time (per-call overrides/additions):
 * This uses the same AdvisorSpec concept, but only for this single request.
 * You typically don’t re-add the advisors here; you just adjust their parameters.
 * If you call .advisors(...) with new advisor instances at request level, they can override or augment the defaults depending on how you use them.
 * eg:
 * String response = chatClient
 *     .prompt()
 *     .advisors(advisorSpec -> advisorSpec
 *         .param(ChatMemory.CONVERSATION_ID, "specific-conversation-123")
 *         .param(QuestionAnswerAdvisor.FILTER_EXPRESSION, "type == 'Spring'")
 *     )
 *     .user("What's new in Spring?")
 *     .call()
 *     .content();
 *
 *
 *  **********  Builder.defaultAdvisors(Consumer<AdvisorSpec>) → configure global defaults for the client.
 * **********  ChatClientRequestSpec.advisors(Consumer<AdvisorSpec>) → configure per-request advisor behavior/parameters.
 *
 *
 * 6. What do the parameters actually do?
 * The param/params you set on AdvisorSpec become part of the advisor context that advisors can read at runtime
 *
 * eg:
 * .advisors(a -> a
 *     .param(ChatMemory.CONVERSATION_ID, conversationId)
 * )
 *
 * MessageChatMemoryAdvisor reads CONVERSATION_ID to know which conversation’s history to load/store.
 *
 * eg2:
 * .advisors(a -> a
 *     .param(QuestionAnswerAdvisor.FILTER_EXPRESSION, "type == 'Spring'")
 * )
 *QuestionAnswerAdvisor uses that filter to restrict which documents are retrieved from the vector store.
 * Other advisors may look for their own keys (e.g., maxMessages, retry counts, tenant IDs, etc.
 *
 *
 * defaultAdvisors(Consumer<AdvisorSpec>) sets up the default advisor chain and default parameters.
 * The per-request .advisors(...) call tweaks parameters for that specific call.
 *
 *
 */


/**
 * Who is implementing AdvisorSpec? (org.springframework.ai.chat.client.ChatClient.AdvisorSpec)
 *
 * AdvisorSpec is implemented by Spring AI itself, not by you. The concrete class is: org.springframework.ai.chat.client.DefaultChatClient.DefaultAdvisorSpec
 *
 *
 *
 * ChatClient.builder(chatModel)
 *     .defaultAdvisors(spec -> { ... })
 *     .build();
 *
 *
 * 1. ChatClient.builder(...) returns a DefaultChatClientBuilder.
 * 2. defaultAdvisors(Consumer<AdvisorSpec>) on that builder:
 *     -> Creates a new DefaultChatClient.DefaultAdvisorSpec instance.
 *     -> Passes it into your Consumer<AdvisorSpec> lambda as spec.
 *     -> Your code calls spec.advisors(...), spec.param(...), etc.
 *     -> After the lambda returns, the builder reads spec.getAdvisors() and spec.getParams() and stores them as default advisor configuration.
 * 3.
 *
 *
 */


/**
 * MessageWindowChatMemory vs MessageChatMemoryAdvisor
 */