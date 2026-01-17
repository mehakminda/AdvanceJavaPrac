package com.learning.telusko.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages={"com.learning.telusko"}) //specify base package
public class JavaConfiguration {

    public JavaConfiguration(){
        System.out.println("Java config instantiated");
    }

    @Bean
    public LocalDateTime createBean(){
        System.out.println("LocalDateTime obj by dev");
        return LocalDateTime.now();
    }

 /*   @Bean  //error No qualifying bean of type 'java.time.LocalDateTime' available: expected single matching bean but found 2: createBean,createBean1
   // @Primary
    public LocalDateTime createBean1(){
        System.out.println("LocalDateTime obj by dev1");
        return LocalDateTime.now();
    }*/
}
