package com.learning.telusko.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LaunchLazy {

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

        Student st= session.load(Student.class, 1);
       // Student st= session.load(Student.class, 4);
        System.out.println("Student id : "+st.getId());
        //put a debug point here and see id is printed before the sql query is executed.
        //Because in load(), a proxy object is created in session cache, which has id=1 value age=null, name=null
        // when we call st.getName(), only then there is a sql query executed. And then it fetches the row details and returns the actual data
        System.out.println("Student name : "+st.getName());
        System.out.println("Student age : "+st.getAge());
        System.out.println("Student city : "+st.getCity());


        Student st1= session.load(Student.class, 1);
        System.out.println("Student id : "+st1.getId());
        System.out.println("Student name : "+st1.getName());
        System.out.println("Student age : "+st1.getAge());
        System.out.println("Student city : "+st1.getCity());

        session.close();
        sessionFactory.close();
    }
}
