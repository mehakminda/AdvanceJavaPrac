package com.learning.telusko.main;

import com.learning.telusko.entity.CarBrand;
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

                CarBrand cb1 =session.get(CarBrand.class,1);
                if(cb1!=null){
                    System.out.println("ID: "+cb1.getBrandID());
                    System.out.println("Name: "+cb1.getBrandName());
                    System.out.print("Car Maker : "+cb1.getCarMaker());
                }
                else {
                    System.out.println("No record found with the given id");
                }

            CarBrand cb2 =session.get(CarBrand.class,2);
            if(cb2!=null){
                System.out.println("ID: "+cb2.getBrandID());
                System.out.println("Name: "+cb2.getBrandName());
                System.out.println("Car Maker: "+cb2.getCarMaker());
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
