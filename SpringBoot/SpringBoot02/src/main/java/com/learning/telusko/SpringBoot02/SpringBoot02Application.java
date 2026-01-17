package com.learning.telusko.SpringBoot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot02Application {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringBoot02Application.class, args);

		int num1=8;
		int num2=9;
		TeluskoCalculator cal=context.getBean(TeluskoCalculator.class);
		System.out.println("Sum is :"+cal.add(num1,num2));
	}

}
