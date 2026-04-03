package com.learning.telusko.bean;

public class Amazon {
    private DeliveryService service;
    static{
        System.out.println("Amazon class is loaded");
    }

    public Amazon() {
        System.out.println("Amazon class object is instantiated");
    }

    public Amazon(DeliveryService service) {
        this.service=service;
    }//constructor injection

    public void setService (DeliveryService service){
        this.service=service;
    } //setter injection

    public boolean initiateDelivery(double amount){
        return service.courrierService(amount);
    }

}
