package com.learning.telusko.bean;

public class BlueDart implements DeliveryService {
    static{
        System.out.println("BlueDart class is loaded");
    }

    public BlueDart() {
        System.out.println("BlueDart class object is instantiated");
    }

    @Override
    public boolean courrierService(double amount) {
        System.out.println( "Courrier delivered safely by BlueDart and the amount was "+amount);
        return true;
    }
}
