package com.learning.telusko;

import com.learning.telusko.services.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot06ProfileApplication implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String projectName;

	@Autowired
	private Courses course;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot06ProfileApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run method");
		System.out.println("Project name is: "+projectName);

		boolean status=course.registerToCourses(300.0);
		if(status) System.out.println("Registered successfully");
		else System.out.println("Failed to register");
	}
}

//run method in CommandLineRunner interface is the first thing to run when the application start