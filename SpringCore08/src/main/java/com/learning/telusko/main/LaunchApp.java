package com.learning.telusko.main;

import com.learning.telusko.beans.Voter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        System.out.println("Conatiner started");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        Voter voter= (Voter) context.getBean("voter");
        voter.checkEligibility();

        context.close();
        System.out.println("Container is stopped");
    }
}
