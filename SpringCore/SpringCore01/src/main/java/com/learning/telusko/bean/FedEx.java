package com.learning.telusko.bean;

public class FedEx implements DeliveryService {
    static{
        System.out.println("FedEx class is loaded");
    }

    public FedEx() {
        System.out.println("FedEx class object is instantiated");
    }
    @Override
    public boolean courrierService(double amount) {
        System.out.println( "Courrier delivered safely by FedEx and the amount was "+amount);
        return true;
    }
}
