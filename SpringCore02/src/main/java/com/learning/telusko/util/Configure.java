package com.learning.telusko.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {
    public Configure(){
        System.out.println("Configure obj is created");
    }

    @Bean
    public void GenerateAlgo(){
        Password p=new Password("SHA1");
    }
    /*
    * This wont work on spring 6 version: Configuration problem: @Bean method 'GenerateAlgo' must not be declared as void; change the method's return type or its annotation.
    *
    * You don't as that doesn't make sense and as such is now forbidden in newer Spring versions
    *
    * There is no other way as using @Bean on void methods doesn't make sense (what is a void bean? ). This is abusing the @Bean to do some initializing callback,
    * for which you should use other means. What you need to change is already included in the message, so tell your 3rd party provider to fix their code or don't
    * use their configuration but copy it and fix it yourself.*/

}


/** Copilot
 * GenerateAlgo was never called then how is it executed?
 * Spring detects the @Bean method and calls it while building the application context. @Configuration classes are parsed by Spring and each @Bean method is invoked to create and register a bean —
 * you don't call it directly. In Spring 6 @Bean methods must return a bean object, so change the method to return Password (or use @PostConstruct for side-effect initialization).
 *
 */

/**
 * Can we add @bean to a class/variable?
 * NO , @bean can only be added to a method.
 * @bean is telling spring, hey spring I(developer) am creating this object, But I want you to manage it and consider it a bean.
 *
 *
 * The @Bean annotation is a method-level annotation used within a @Configuration (or @Component) class to explicitly declare that the object returned by that method should be managed by the Spring IoC container
 *
 */