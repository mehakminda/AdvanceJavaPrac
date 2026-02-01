package com.learning.telusko;

import com.learning.telusko.dao.Employee;
import com.learning.telusko.dao.EmployeeDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class SpringJdbc01Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(SpringJdbc01Application.class, args);

		System.out.println("Beans names getting created behind the scene:  "+ Arrays.toString(context.getBeanDefinitionNames()));
		//check for datasource and Employee bean

		EmployeeDaoImpl emp=context.getBean(EmployeeDaoImpl.class);
		List<Employee> list=emp.getTheEmployees();


		//iterator/for each
		Iterator<Employee> itr=list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}

		list.forEach(em -> System.out.println(em));

		emp.getTheEmployees().forEach(em-> System.out.println(em));


		context.close();
	}

}
