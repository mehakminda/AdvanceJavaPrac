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

/**
 * who inject object to this @Autowired LocalDateTime date;?
 *
 * The LocalDateTime instance is provided by the @Bean method in JavaConfiguration:
 * 1. File: src/main/java/com/learning/telusko/config/JavaConfiguration.java
 * 2. Method: public LocalDateTime createBean() { return LocalDateTime.now(); }
 *
 * Spring creates that bean when the application context is built (you can see it prints "LocalDateTime obj by dev") and, because the bean is of type java.time.LocalDateTime, Spring injects that bean (by type) into the date field of your GreetMe component.
 *
 * How the wiring works (brief)
 * 1. JavaConfiguration is annotated with @Configuration and @ComponentScan, so Spring discovers both the @Bean and the @Component.
 * 2. createBean() registers a LocalDateTime bean (bean name defaults to "createBean").
 * 3. @Autowired on the LocalDateTime date field causes Spring to look up a bean of type LocalDateTime and set the field with that bean.
 */