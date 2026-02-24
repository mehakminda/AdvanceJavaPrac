package com.learning.telusko.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cname;
    private String city;
    private LocalDateTime dob;

    private LocalTime registerationTime;
    private LocalDate registrationDate;

    public CustomerDetails() {
        System.out.println("Customer pojo zero params constructor");
    }

    public CustomerDetails(String cname, String city, LocalDateTime dob, LocalTime registerationTime, LocalDate registrationDate) {
        this.cname = cname;
        this.city = city;
        this.dob = dob;
        this.registerationTime = registerationTime;
        this.registrationDate = registrationDate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalTime getRegisterationTime() {
        return registerationTime;
    }

    public void setRegisterationTime(LocalTime registerationTime) {
        this.registerationTime = registerationTime;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", city='" + city + '\'' +
                ", dob=" + dob +
                ", registerationTime=" + registerationTime +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
