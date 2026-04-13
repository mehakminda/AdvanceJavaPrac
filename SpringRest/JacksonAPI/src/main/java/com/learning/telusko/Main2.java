package com.learning.telusko;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.telusko.pojo.Implementors2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main2 {
    static void main() throws IOException {
        //Json object to Java object

        //Create ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //json to java
        Implementors2 impl2 = mapper.readValue(new File("jsonData/sample.json"), Implementors2.class);

        //printing the data on console received from json and converted to java obj
        System.out.println("Id: " +impl2.getId());
        System.out.println("Name: "+impl2.getName());
        System.out.println("City: "+impl2.getCity());
        System.out.println("Active learner: "+impl2.isActive());

        System.out.println("----------------------------------------------------");

        //json to java
        Implementors2 impl21 = mapper.readValue(new File("jsonData/sample2.json"), Implementors2.class);

        //printing the data on console received from json and converted to java obj
        System.out.println("Id: " +impl21.getId());
        System.out.println("Name: "+impl21.getName());
        System.out.println("City: "+impl21.getCity());
        System.out.println("Active learner: "+impl21.isActive());

        System.out.println("Course details:"+ impl21.getCourse());
        System.out.println("SkillSet: "+impl21.getSkills().toString());
        System.out.println("Hobbies : "+ Arrays.toString(impl21.getHobbies()));
        //iterate through an new array
        for(String x: impl21.getHobbies()){
            System.out.print(x +" ");
        }
        System.out.println();
    }
}
