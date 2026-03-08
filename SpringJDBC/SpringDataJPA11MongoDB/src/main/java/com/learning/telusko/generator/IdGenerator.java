package com.learning.telusko.generator;

//This is totally optional
//MongoDb automatically generates ID as Object_id, suppose we want to generate it from code, here is how we can do
//This is like a utility class

import org.springframework.context.annotation.Bean;

import java.util.UUID;

public class IdGenerator {

    public static String generateID(){
        System.out.println("Custom ID generator is called");
        //return UUID.randomUUID().toString().replace("-","").substring(0,10);
        return UUID.randomUUID().toString();

        //we can modify it as per our requirement
    }

}
