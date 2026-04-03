package com.learning.telusko.main;

import com.learning.telusko.bean.Amazon;
import com.learning.telusko.bean.FedEx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Code to Interface
public class Main {
    public static void main(String[] args) {
        //Normal without spring
//        Amazon a=new Amazon();
//        a.setService(new FedEx());
//        boolean status=a.initiateDelivery(123.4);
//        if(status) System.out.println("Order delivered successfully");
//        else System.out.println("Failed to deliver");

        //With Spring
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //Loads and instantiates all the objects which for beans are defined in applicationContext.xml


        //method1:
        System.out.println("Method1:");
        Amazon amz=context.getBean("amazon",Amazon.class);
        amz.initiateDelivery(123.4);

        //method2:
        System.out.println("Method2:");
        Amazon amz1= (Amazon) context.getBean("amazon");
        amz1.initiateDelivery(123.4);

        //method3:
        System.out.println("Method3:");
        Amazon amz2=context.getBean(Amazon.class);
        amz2.initiateDelivery(123.4);

    }
}