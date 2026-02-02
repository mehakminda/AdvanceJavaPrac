package com.learning.telusko.main;

import com.learning.telusko.com.learning.telusko.utils.HibernateUtil;
import com.learning.telusko.entity.Account;
import com.learning.telusko.entity.Employee2;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LaunchApp {
    public static void main(String[] args) {
        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

        try{
            session= HibernateUtil.getSesssion();
            if(session!=null){
                transaction=session.beginTransaction();

                Account acc=new Account();
                acc.setAccNo("Telusko01");
                acc.setName("Richie Rich");
                acc.setAccType("Saving");

                Employee2 e2=new Employee2();
                e2.setAccount(acc);
                e2.setCity("Hyd");
                e2.setSalary(10.1);
                e2.setName("Mehak");

                session.save(e2);
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
// Even though we have not defined foreign key, by default primary key of the account table is mapped to the foreign key of employee2 table.
//and the corresponding column is added in employee2 table
