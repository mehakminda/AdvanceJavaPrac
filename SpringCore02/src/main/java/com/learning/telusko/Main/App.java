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
