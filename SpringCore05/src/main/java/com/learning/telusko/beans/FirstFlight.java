package com.learning.telusko.beans;

public class FirstFlight implements DeliveryService {
    static{
        System.out.println("FirstFlight class is loaded");
    }

    public FirstFlight() {
        System.out.println("FirstFlight class object is instantiated");
    }

    @Override
    public boolean courrierService(double amount) {
        System.out.println( "Courrier delivered safely by FirstFlight and the amount was "+amount);
        return true;
    }
}
