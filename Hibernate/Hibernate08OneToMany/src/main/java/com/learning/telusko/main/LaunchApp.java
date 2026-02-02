package com.learning.telusko.main;

import com.learning.telusko.entity.Doctor;
import com.learning.telusko.entity.Patient;
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

                Patient p1=new Patient("Eric",new Date());
                Patient p2=new Patient("Phillipe",new Date());

                Set<Patient> patientSet=new HashSet<>();
                patientSet.add(p1);
                patientSet.add(p2);

                Doctor d1= new Doctor();
                d1.setDoctorID(1);
                d1.setDoctorEmail("mminda@mkalader.com");
                d1.setDoctorName("Mehak Minda");
                d1.setDoctorSpeciality("Surgeon");
                d1.setPatients(patientSet);

                session.save(d1);
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


