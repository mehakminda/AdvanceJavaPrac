package com.learning.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot03Application { //this class is also instantiated by spring, hence is a bean

	static{
		System.out.println("Spring Boot 03 App");
	}

	public SpringBoot03Application(){
		System.out.println("SpringBoot03Application bean created");
	}

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringBoot03Application.class, args);
		System.out.println("Spring container used here: "+context.getClass().getName());
		System.out.println("Beans getting created behind the scene:  ");
	}

}
