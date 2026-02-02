package com.learning.telusko.entity;

import jakarta.persistence.*;

@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandID;

    private String BrandName;

    @ManyToOne(cascade = CascadeType.ALL)
    private CarMaker carMaker;

    public CarBrand(){
        System.out.println("Zero-Param constructor of Car Brand");
    }

    public CarBrand(String brandName, CarMaker carMaker) {
        System.out.println("Parameterized constructor of Car Brand");
        BrandName = brandName;
        this.carMaker = carMaker;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public CarMaker getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(CarMaker carMaker) {
        this.carMaker = carMaker;
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "brandID=" + brandID +
                ", BrandName='" + BrandName + '\'' +
                ", carMaker=" + carMaker +
                '}';
    }
}
