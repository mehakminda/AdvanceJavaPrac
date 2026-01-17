package com.learning.telusko.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GreetMe {

    @Autowired
    LocalDateTime date;

    public GreetMe() {
        System.out.println("GreetMe bean created..");
    }

    public String  generateGreeting(String name){
            int hour=date.getHour();
            if(hour<12) return "Good Morning! " +name;
            else if(hour <16) return "Good Afternoon! " + name;
            else if(hour <20) return "Good evening! "+name;
            else return "Good night! "+name;
    }
}
