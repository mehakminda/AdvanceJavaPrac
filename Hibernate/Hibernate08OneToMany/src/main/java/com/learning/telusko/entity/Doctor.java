package com.learning.telusko.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.Set;

@Entity
public class Doctor {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorID;

    private String doctorName;

    private String doctorEmail;

    private String doctorSpeciality;

    @OneToMany(cascade= CascadeType.ALL)
    private Set<Patient> patients; //one doctor can have many patients

    public Doctor(){
        System.out.println("Doctor zero params Constructor for hibernate");
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", doctorName='" + doctorName + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorSpeciality='" + doctorSpeciality + '\'' +
                ", patients=" + patients +
                '}';
    }
}
