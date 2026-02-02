package com.learning.telusko.main;

import com.learning.telusko.entity.Implementers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LaunchRetrieval {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().
                addAnnotatedClass(Implementers.class).buildSessionFactory();

        Session session=sessionFactory.openSession();

        Implementers imp=session.get(Implementers.class,1);
        if(imp!=null){
            /*System.out.println("ID: "+imp.getId());
            System.out.println("Name: "+imp.getName());
            System.out.println("Date: "+imp.getDate());
            System.out.println("Time: "+imp.getTime());
            System.out.println("TimeStamp: "+imp.getDateAndTime());*/
            System.out.println(imp);

        }
        else{
            System.out.println("Record does not exists in the table");
        }
        session.close();
        sessionFactory.close();
    }
}
