package com.learning.telusko.util;

public class Password {
    public Password(){
        System.out.println("Password obj has been created ");
    }
    public Password(String algo){
        System.out.println("The password has been created by "+algo);
    }
    public void disp(){
        System.out.println("Password obj created by dev but its still a bean and is managed by spring container");
    }
}
