package com.learning.telusko.main;

import com.learning.telusko.entity.Student2;
import com.learning.telusko.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApp1 {
    public static void main(String[] args) {

        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

        try {
            session = HibernateUtil.getSesssion();

            if(session!=null)  transaction =session.beginTransaction();

            if(transaction!=null) {
                Student2 st= new Student2();
                st.setId(1);
                st.setName("Mehak");
                st.setAge(20);
                st.setCity("Hyderabad");

                session.save(st);
                flag=true;

            }
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(flag==true) {
                transaction.commit();
            }
            else{
                transaction.rollback();
                System.out.println("Not able to store data in DB!");
            }
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
}