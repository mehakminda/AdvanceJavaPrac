package com.learning.telusko.main;

import com.learning.telusko.main.beans.Amazon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot01Application {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringBoot01Application.class, args);

		Amazon amazon = context.getBean( Amazon.class);
		boolean status=amazon.initiateDelivery(45.0);

		if (status) {
			System.out.println("Delivery successfully.");
		} else {
			System.out.println("Delivery failed.");
		}

	}

}
