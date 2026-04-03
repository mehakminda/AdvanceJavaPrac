package com.learning.telusko.main;

import com.learning.telusko.beans.GreetMe;
import com.learning.telusko.config.JavaConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfiguration.class); //no xml only annotation

        GreetMe greet=context.getBean(GreetMe.class);
        System.out.println(greet.generateGreeting("Mehak"));


    }
}
