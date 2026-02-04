package com.learning.telusko;

import com.learning.telusko.beans.CourseSelection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringBoot05Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBoot05Application.class, args);
		CourseSelection courseSelection=context.getBean(CourseSelection.class);

		// Ask the user which course to choose at runtime
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter course name (java, hibernate, springBoot) or press Enter to use default: ");
		String courseName = null;
		try {
			courseName = scanner.nextLine().trim();
		} catch (Exception e){
			// ignore input errors and fall back to default
		}

		boolean status;
		if(courseName == null || courseName.isEmpty()){
			// fallback to original behavior (uses the autowired 'java' qualifier if present)
			status = courseSelection.chooseCouse(5000);
		} else {
			status = courseSelection.chooseCouse(courseName, 5000);
		}

		if(status) System.out.println("Success");
		else System.out.println("Failed");

		context.close();

	}

}
