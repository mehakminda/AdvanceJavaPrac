package com.learning.telusko.main;

import com.learning.telusko.beans.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class LaunchLazyLoad {
    public static void main(String[] args) {

        //lazyLoading:  object created when requested

        /*
        //method1
        Resource resource=new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        */

        //method2
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
       XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions("applicationContext.xml");
        reader.loadBeanDefinitions("applicationContext2.xml");
        //with defaultlistablebeanfactory we can load multiple configuration file for a spring container
        //with classPathXmlApplicationContext we can load only 1 configuration file per spring container

        Employee emp1=factory.getBean("emp1", Employee.class); // it creates the requested bean only not all beans mentioned in configuration file
        System.out.println("Hello from emp1"); //so far only 1 parameterized constructors has been invoked. ie only 1 bean has been created

        Employee emp2=factory.getBean("emp2", Employee.class); // now 2nd bean is created
        System.out.println("Hello from emp2");


       // BeanFactory factory = new DefaultListableBeanFactory()

    }
}
