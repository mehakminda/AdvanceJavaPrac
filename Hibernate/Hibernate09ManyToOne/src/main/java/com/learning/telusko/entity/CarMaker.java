package com.learning.telusko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class CarMaker {

    @Id
    private  Integer companyId;
    private String copmanyName;
    private Date yearFounded;

    public CarMaker(){
        System.out.println("zero param constructor of CarMaker");
    }

    public CarMaker(Integer companyId, String copmanyName, Date yearFounded) {
        System.out.println("Parameterised constructor of CarMaker");
        this.companyId = companyId;
        this.copmanyName = copmanyName;
        this.yearFounded = yearFounded;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCopmanyName() {
        return copmanyName;
    }

    public void setCopmanyName(String copmanyName) {
        this.copmanyName = copmanyName;
    }

    public Date getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Date yearFounded) {
        this.yearFounded = yearFounded;
    }

    @Override
    public String toString() {
        return "CarMaker{" +
                "companyId=" + companyId +
                ", copmanyName='" + copmanyName + '\'' +
                ", yearFounded=" + yearFounded +
                '}';
    }
}

