package com.learning.telusko.main;

import com.learning.telusko.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApp1 {
    public static void main(String[] args) {


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session =sessionFactory.openSession();

        Integer id=5;
        //Student st=session.get(Student.class,id);
        Student st=session.load(Student.class,id);
        if(st!=null){
            System.out.println("if block");
            Transaction transaction=session.beginTransaction();
            session.delete(st);
            transaction.commit();
        }
        else{
            System.out.println(" Record no available with id: "+id);
        }


        session.close();
        sessionFactory.close();
    }
}
// no loading driver/creating statement/writing sql query.... all these eliminated