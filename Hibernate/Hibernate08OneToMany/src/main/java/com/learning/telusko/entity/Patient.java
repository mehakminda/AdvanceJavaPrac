package com.learning.telusko.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientID;

    private String patientName;

    @Temporal(TemporalType.DATE)
    private Date patientDOB;

    public Patient(){
        System.out.println("Zero Param constructor of patient class");
    }

    public Patient( String patientName, Date patientDOB) {
        System.out.println(" Parameterised constructor of patient class");
        this.patientName = patientName;
        this.patientDOB = patientDOB;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Date getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(Date patientDOB) {
        this.patientDOB = patientDOB;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", patientName='" + patientName + '\'' +
                ", patientDOB=" + patientDOB +
                '}';
    }
}



