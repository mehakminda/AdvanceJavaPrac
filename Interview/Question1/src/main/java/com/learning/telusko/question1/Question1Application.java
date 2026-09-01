package com.learning.telusko.question1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Question1Application {

    public static void main(String[] args) {
        SpringApplication.run(Question1Application.class, args);
    }

}

/**
 * Write a Java Spring Boot REST endpoint that receives a list of order IDs as input and returns
 * a summary (total amount, count, min/max order value) for those orders from a PostgreSQL database.
 * Ensure input validation, efficient DB querying, and handle cases where some IDs do not exist.
 */

//Refer: https://share.google/aimode/UpZYc8HFW30HxCiKh