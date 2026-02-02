package com.learning.telusko.com.learning.telusko.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Helper class for main class
// all common method will be here
public class HibernateUtil {
    private static SessionFactory sessionFactory=null;
    private static Session session=null;

    static{
        System.out.println("HibernateUtil class is loaded");
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public static Session getSesssion(){
        if(session==null) session = sessionFactory.openSession();
        return session;
    }

    public static void closeSession(Session session){
        if(session!=null) session.close();
    }
    public static void closeSessionFactory(){
        if(sessionFactory!=null) sessionFactory.close();
    }

//There is 1 session factory, but there can be multiple session.
}
