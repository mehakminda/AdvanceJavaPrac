package com.learning.telusko.main;

import com.learning.telusko.entity.Cart;
import com.learning.telusko.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LaunchRetrieval {
    public static void main(String[] args) {
        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

        try{
            session= HibernateUtil.getSesssion();

            Integer id=1;
                Cart c1 =session.get(Cart.class,id);
                if(c1!=null){
                    System.out.println("ID: "+c1.getCart_ID());
                    System.out.println("Total Items in Cart: "+c1.getCart_Total());
                    System.out.print("Items List : ");
                    c1.getItems().forEach(items->{
                        System.out.println("Item: "+items);
                    });
                }
                else {
                    System.out.println("No record found with the given id:"+id);
                }

                id=2;
            Cart c2 =session.get(Cart.class,id);
            if(c2!=null){
                System.out.println("ID: "+c2.getCart_ID());
                System.out.println("Total Items in Cart: "+c2.getCart_Total());
                System.out.print("Items List : ");
                c2.getItems().forEach(items->{
                    System.out.println("Item: "+items);
                });
            }
                else {
                    System.out.println("No record found with the given id: "+id);
                }

        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {

            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
}
