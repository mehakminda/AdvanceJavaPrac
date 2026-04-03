package com.learning.telusko.main;

import com.learning.telusko.beans.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Eager Loading:  the moment we specify the bean in the configuration file, spring container creates the object RIGHT AWAY
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

		Employee e=  context.getBean("emp1",Employee.class);
		System.out.println(e);
		System.out.println( e.empActivity());
		System.out.println("***********************");

		Employee e2=context.getBean("emp2",Employee.class);
		System.out.println(e2);
		System.out.println(e2.empActivity());
		System.out.println("***********************");

		Employee e3=context.getBean("emp3",Employee.class);
		System.out.println(e3);
		System.out.println(e3.empActivity());
		System.out.println("***********************");

		Employee	e4=context.getBean("emp4",Employee.class);
		System.out.println(e4);
		System.out.println(e4.empActivity());
		System.out.println("***********************");


	}
	
}
