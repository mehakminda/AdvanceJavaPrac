package com.learning.telusko.main;

import com.learning.telusko.beans.Amazon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Amazon amazon = context.getBean("amazon", Amazon.class);
        boolean status=amazon.initiateDelivery(45);

        if (status) {
            System.out.println("Delivery successfully.");
        } else {
            System.out.println("Delivery failed.");
        }
    }
}
