package com.learning.telusko.main;

import com.learning.telusko.entity.CarBrand;
import com.learning.telusko.entity.CarMaker;

import com.learning.telusko.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LaunchApp {
    public static void main(String[] args) {
        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

        try{
            session= HibernateUtil.getSesssion();
            if(session!=null){
                transaction=session.beginTransaction();

                CarMaker cm=new CarMaker(1,"Volkswagen ",new Date());
                CarBrand cb1=new CarBrand("Audi ", cm);
                CarBrand cb2=new CarBrand("Porsche", cm);

                session.save(cb1);
                session.save(cb2);
                flag=true;
            }
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
           if(flag){
               transaction.commit();
               System.out.println("Data is saved");
           }
           else{
               transaction.rollback();
               System.out.println("Not able to store data in db");
           }
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
}


