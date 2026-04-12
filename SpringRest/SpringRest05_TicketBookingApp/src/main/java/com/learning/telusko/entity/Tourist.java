package com.learning.telusko.entity;

import jakarta.persistence.*;

//same pojo for json from client and another pojo for data from db, or one pojo for both

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long tId;
    private String tName;
    private String city;
    private String packageType;
    private Double budget;

    public Tourist() {
        System.out.println("No params constructor");
    }

    public Long getTId() {
        return tId;
    }

    public void setTId(Long tId) {
        this.tId = tId;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", city='" + city + '\'' +
                ", packageType='" + packageType + '\'' +
                ", budget=" + budget +
                '}';
    }
}
