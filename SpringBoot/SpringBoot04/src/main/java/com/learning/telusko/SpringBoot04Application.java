package com.learning.telusko;

import com.learning.telusko.beans.Course;
import com.learning.telusko.beans.CourseSelection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot04Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context=SpringApplication.run(SpringBoot04Application.class, args);
		CourseSelection courseSelection=context.getBean(CourseSelection.class);
		boolean status=courseSelection.chooseCouse(5000);

		if(status) System.out.println("Success");
		else System.out.println("Failed");

		context.close();
	}

}
