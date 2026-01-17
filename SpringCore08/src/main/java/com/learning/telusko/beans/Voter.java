package com.learning.telusko.beans;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value="voter")
@PropertySource(value= "com/learning/telusko/commons/application.properties") //there is some data in some file, i want to use that data in this class
public class Voter {

    @Value("${voter.info.name}")
    private String name;

    @Value("${voter.info.age}")
    private int age;

    static{
        System.out.println("voter class loading ...");
    }

    public Voter(){
        System.out.println("Voter is instantiated");
    }

    @PostConstruct //gets executed after object creation/ after constructor
    public void init(){
        System.out.println("Init method");
    }
    //Busniess Logic
    public String checkEligibility(){
        System.out.println("Method call with business logic");
        if(age>18) return("You can vote "+ this.name);
        else return("You cannot vote "+this.name);
    }

    @PreDestroy //gets executed before object/bean is destroyed
    public void destroy(){
        System.out.println("Bean is destroyed");
    }
}
