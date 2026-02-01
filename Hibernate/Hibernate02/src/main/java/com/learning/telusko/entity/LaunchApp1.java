package com.learning.telusko.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApp1 {
    public static void main(String[] args) {

        //Inform JVM to activate Hibernate
        Configuration config=new Configuration();
        // Load configuration from the classpath (src/main/resources/hibernate.cfg.xml)
        config.configure();

        //Creating session factory object to hold all other required objects for hibernate
        // connection pooling, transaction object, loading driver, managing driver, creating statement
        SessionFactory sessionFactory=config.buildSessionFactory();

        //Persistence operation
        Session session= sessionFactory.openSession(); //telling objects in factory to start doing your job/tasks

        /**
         * Query are of 2 types "select" and "non-select"
         * select query: retrival of balance, if error occur we can re-open the app. Method:  get() and load()
         * non-select: insertion/ updating/deleting data, for this transaction is needed. WE must always have a "transaction object".
         */

        //only for non-select operation transaction must be there
         Transaction transaction =  session.beginTransaction();

         //Create persistent object
       /* Student st=new Student();
        st.setId(1);
        st.setAge(30);
        st.setName("Mehak Minda");
        st.setCity("New York");*/

        //this will give there as there is no row with id 2 to update, so we have to use a method called saveOrUpdate
       Student st=new Student();
        st.setId(2);
        st.setAge(30);
        st.setName("Mehak");
        st.setCity("New York");

        //perform persistence operation
        //session.update(st);
        session.saveOrUpdate(st);

        //commit the operation
        transaction.commit(); //no rollback

        session.close();
        sessionFactory.close();
    }
}
// no loading driver/creating statement/writing sql query.... all these eliminated