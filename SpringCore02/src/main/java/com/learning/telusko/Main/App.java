package com.learning.telusko.Main;

import com.learning.telusko.util.Password;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        //invoke spring
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        Password passwd=  context.getBean(Password.class);
        passwd.disp();


    }
}

//This code is incorrect , find the error??
//hint: which password bean is injected in line 19?

/**
 * There are 2 pass objects created here, one is bean due to  @component in password class and another object coz of new Password() in generateAlgo
 *
 * This code works coz there is a @component annotation in password class. That bean is taken here instead of the bean is that created by @component where the algo is null
 *
 * If we remove that @component, this code fails , as we should return Password object in generatealgo method
 *
 * There remove @component and change return type of generate algo.
 *
 *If we dont remove @component and keep both, we will get duplicate bean error.
 *
 */


/**
 * Why is generateAlgo called factory method?
 *
 * @Bean marks a method that creates (manufactures) a bean for the Spring container. That’s why it’s called a factory method: the method is the factory that builds and returns the object that becomes the bean.
 */