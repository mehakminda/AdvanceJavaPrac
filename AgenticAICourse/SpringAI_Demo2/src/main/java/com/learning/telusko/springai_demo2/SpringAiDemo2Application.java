package com.learning.telusko.springai_demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAiDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiDemo2Application.class, args);
    }

}
/***
 * MultiModel ai features:
 *
 * text -> image
 * image +text -> describe image
 *
 * text -> audio
 * audio+text ->describe audio
 */