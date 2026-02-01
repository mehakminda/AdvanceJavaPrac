package com.learning.telusko;

import com.learning.telusko.dao.CourseInfo;
import com.learning.telusko.dao.SpringJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {

    @Autowired
    private SpringJDBC springJDBC;


    @Override
    public void run(String... args) throws Exception { //run method is CommandLine Runner will be executed as soon as the application is loaded
        springJDBC.insert();
        System.out.println("Data Inserted completed");

        springJDBC.insert2(new CourseInfo(1,"Java"));
        springJDBC.insert2(new CourseInfo(2,"Spring"));
        springJDBC.insert2(new CourseInfo(3,"Hibernate"));
        System.out.println("Data Inserted 2 completed");

        springJDBC.deleteById(2);
        System.out.println(springJDBC.findByID(1));
        System.out.println(springJDBC.findByID(3));
    }
}

/**
 * To verify access the h2 in memory database console as localhost:8080/h2-console
 */