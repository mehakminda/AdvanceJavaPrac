package com.learning.telusko.main;

import com.learning.telusko.entity.Doctor;
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

                Doctor d1 =session.get(Doctor.class,1);
                if(d1!=null){
                    System.out.println("ID: "+d1.getDoctorID());
                    System.out.println("Name: "+d1.getDoctorName());
                    System.out.println("Email: "+d1.getDoctorEmail());
                    System.out.print("Patients list : ");
                    d1.getPatients().forEach( patient -> System.out.println(patient)); //calls toString of patient
                    System.out.println("Speciality:  "+d1.getDoctorSpeciality());

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
