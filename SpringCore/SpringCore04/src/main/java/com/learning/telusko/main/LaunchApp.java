package com.learning.telusko.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {

        //Eager Loading
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
