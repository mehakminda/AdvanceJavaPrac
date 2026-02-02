package com.learning.telusko.main;

import com.learning.telusko.com.learning.telusko.utils.HibernateUtil;
import com.learning.telusko.entity.Account;
import com.learning.telusko.entity.Employee2;
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

                Employee2 e2 =session.get(Employee2.class,1);
                if(e2!=null){
                    System.out.println("ID: "+e2.getId());
                    System.out.println("Name: "+e2.getName());
                    System.out.println("City: "+e2.getCity());
                    System.out.println("Account : "+e2.getAccount()); //calls toString of account
                    System.out.println("Salary "+e2.getSalary());

                }
                else {
                    System.out.println("No record found with the given id");
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
