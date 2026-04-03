package com.learning.telusko.main;

import com.learning.telusko.beans.Department;
import com.learning.telusko.beans.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        /*Department dept=context.getBean(Department.class);
        System.out.println(dept);*/
        Employee e= context.getBean(Employee.class);
        System.out.println(e);
    }
}
