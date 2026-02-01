package com.learning.telusko.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LaunchEager {
    public static void main(String[] args) {

        //Inform JVM to activate Hibernate
        Configuration config=new Configuration();
        // Load configuration from the classpath (src/main/resources/hibernate_rename.cfg.xml)
        config.configure("hibernate_rename.cfg.xml");

        //Creating session factory object to hold all other required objects for hibernate
        // connection pooling, transaction object, loading driver, managing driver, creating statement
        SessionFactory sessionFactory=config.buildSessionFactory();
        System.out.println("Name of the class implementing session factory : "+sessionFactory.getClass().getName()); //org.hibernate.internal.SessionFactoryImpl

        //Persistence operation
        Session session= sessionFactory.openSession(); //telling objects in factory to start doing your job/tasks

       //non-select query need not have transaction object

        Student st= session.get(Student.class, 14);
        System.out.println("Student id : "+st.getId());
        System.out.println("Student name : "+st.getName());
        System.out.println("Student age : "+st.getAge());
        System.out.println("Student city : "+st.getCity());

/*
        Student st1= session.get(Student.class, 1);
        System.out.println("Student id : "+st1.getId());
        System.out.println("Student name : "+st1.getName());
        System.out.println("Student age : "+st1.getAge());
        System.out.println("Student city : "+st1.getCity());
*/
 /*       Student st1= session.get(Student.class, 2);
        System.out.println("Student id : "+st1.getId());
        System.out.println("Student name : "+st1.getName());
        System.out.println("Student age : "+st1.getAge());
        System.out.println("Student city : "+st1.getCity());*/




        session.close();
        sessionFactory.close();
    }
}
//How many times hibernate created object of student..... once.... no args constructor is called only once.
//query is executed is once
//Its keeping query output/student class object for that row  in session cache memory

//if id being fetched is different then, 2 query will be executed, 2 constructor will be called