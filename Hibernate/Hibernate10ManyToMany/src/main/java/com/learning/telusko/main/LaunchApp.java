package com.learning.telusko.main;

import com.learning.telusko.entity.Cart;
import com.learning.telusko.entity.Item;
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

                Item i1=new Item(1,"Oil Paints ", 800.0);
                Item i2=new Item(2,"Acrylic Paints ", 500.0);
                Item i3=new Item(3,"Brush ", 40.0);
                Item i4=new Item(4,"Gown", 5000.0);

                Set<Item> itemsList1=new HashSet<>();
                itemsList1.add(i1);
                itemsList1.add(i2);
                itemsList1.add(i3);

                Set<Item> itemsList2=new HashSet<>();
                itemsList2.add(i2);
                itemsList2.add(i3);
                itemsList2.add(i4);

                Cart c1=new Cart(itemsList1.size(),itemsList1);
                Cart c2=new Cart(itemsList2.size(),itemsList2);

                session.save(c1);
                session.save(c2);
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


