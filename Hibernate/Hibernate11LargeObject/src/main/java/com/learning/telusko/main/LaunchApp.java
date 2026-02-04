package com.learning.telusko.main;


import com.learning.telusko.entity.Profile;
import com.learning.telusko.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileInputStream;
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

               Profile profile1=new Profile();
               profile1.setProfileId(1);
               profile1.setProfileName("Mehak Minda");

               //alternatively we can use bufferInputStream
                //FileInputStream fis=new FileInputStream( "C:\\learning\\teluskojava\\spring\\Hibernate\\Hibernate11LargeObject\\src\\main\\resources\\testdata\\propic.jpeg");
                FileInputStream fis=new FileInputStream( "src//main//resources//testdata//propic.jpeg");
                byte imgArray[]=new byte[fis.available()]; //create an array of size same as the image size
                fis.read(imgArray);

               profile1.setImage(imgArray);

               String text="This is a replica of text file";
               char[] charArray=text.toCharArray();
               profile1.setCharFile(charArray);

                session.save(profile1);
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


