package com.learning.telusko.main.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Amazon {

    private DeliveryService service;

    static{
        System.out.println("Amazon class is loaded");
    }

    public Amazon() {
        System.out.println("Amazon class object is instantiated");
    }

    @Autowired
    public Amazon(@Qualifier("bluedart") DeliveryService service) {
        this.service=service;
    }//constructor injection


    public void setService (DeliveryService service){
        this.service=service;
    } //setter injection

    public boolean initiateDelivery(double amount){
        return service.courrierService(amount);
    }
}

//@Qualifier can be applied be method, field and local variable
// local variable as in, in constructor :  public Amazon(@Qualifier("ff") DeliveryService service) {