package com.learning.telusko.main;

import com.learning.telusko.entity.Implementers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Date;

public class LaunchApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Implementers.class).buildSessionFactory();

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Implementers imp=new Implementers();
        imp.setId(1);
        imp.setName("Mehak");
        imp.setDate(new Date());
        imp.setTime(new Date()); // because we have mentioned temporal type, it will take what ever it wants ie only the time
        imp.setDateAndTime(new Date());

        session.save(imp);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
