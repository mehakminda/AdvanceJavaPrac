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

//    @Autowired
//    public Amazon(@Qualifier("bluedart") DeliveryService service) {
//        this.service=service;
//    }//constructor injection


   /* public Amazon( DeliveryService service) {
        System.out.println("parameterised constructor of amazon class");
    }*/


    @Autowired

    public void setService ( @Qualifier("ff")DeliveryService service){
        this.service=service;
    } //setter injection

    public boolean initiateDelivery(double amount){
        return service.courrierService(amount);
    }
}

//@Qualifier can be applied be method, field and local variable
// local variable as in, in constructor :  public Amazon(@Qualifier("ff") DeliveryService service) {

/**
 * Spring autowiring is by-type. If multiple beans implement the same type, Spring disambiguates using, in order: @Primary, @Qualifier, or a name match between the dependency name and a bean name.
 * For setter/field injection Spring uses the property/field name (which often matches a bean name), so a @Qualifier may not be required.
 * For constructor parameters, Java parameter names are available to Spring only if you compile with -parameters; otherwise Spring can't match by name and you must use @Qualifier (or @Primary).
 */