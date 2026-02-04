package com.learning.telusko.main;


import com.learning.telusko.entity.Profile;
import com.learning.telusko.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class LaunchRetrieval {
    public static void main(String[] args) {
        Session session=null;
        Transaction transaction=null;
        boolean flag=false;

        try{
            session= HibernateUtil.getSesssion();

            System.out.println("*******************************");
            Integer id=1;
                Profile p1 =session.get(Profile.class,id);
                if(p1!=null){
                    System.out.println("ID: "+p1.getProfileId());
                    System.out.println("Profile: "+p1.getProfileName());

                    //store image as byte array
                    byte img[]= p1.getImage();
                    FileOutputStream fos=new FileOutputStream("propic-output.jpeg");
                    fos.write(img);

                    char charArray[]=p1.getCharFile();
                    FileWriter fw=new FileWriter("java.txt");
                    fw.write(charArray);

                    fw.flush();


                }
                else {
                    System.out.println("No record found with the given id:"+id);
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
