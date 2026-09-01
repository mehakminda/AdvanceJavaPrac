package com.learning.telusko;


import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public class AiServiceBasics4 {

    interface CourseAssistant{


        String chat(String userMessage);

        @SystemMessage(""" 
                You are helpful assistant for Java and spring boot training company
                Answer in at most three sentences.
                If the question i snot about programming, politely refuse
                """)
        String ask(String userMessage);


        @UserMessage(" Explain {{topic}} to a java developer who has never seen it before in 1 line")
        String explain(@V("topic") String topic);


        @UserMessage(" Explain {{topic}} to a {{level}}. Use atmost {{lines}} lines")
        String explainFor(@V("topic") String topic,
                          @V("level") String level,
                          @V("lines") int lines);


    }

    static void main() {

        CourseAssistant assistant = AiServices.create(CourseAssistant.class, Models.chat());
        /*System.out.println("-- Plain Chat ---");
        assistant.chat(assistant.chat("What is JAR file?"));
        System.out.println("-----------------------------------");


        System.out.println("-- System Message Example ---");
        System.out.println(assistant.ask("What is spring boot?"));
        System.out.println("-----------------------------------");



        System.out.println("-- User Message Prompt template ---");
        System.out.println(assistant.explain(" polymorphism"));
        System.out.println("-----------------------------------");


        System.out.println("-- Multiple parameter  Prompt template ---");
        System.out.println(assistant.explainFor("garbage collection", "junior",5));
        System.out.println("-----------------------------------");*/


        System.out.println("-- System Message Example ---");
        System.out.println(assistant.ask("Give me recipe for paneer tikka"));
        System.out.println("-----------------------------------");


        System.out.println("Our AI assistant implemented by : "+assistant.getClass().getName()); //refection api
        //com.learning.telusko.$Proxy4
        //based on proxy design pattern
        //just like @transaction create proxy








    }
}
/**
 * just like spring data jpa, which has custom finder method.
 *
 * we will create interface and langchain will implement it.
 *
 */
