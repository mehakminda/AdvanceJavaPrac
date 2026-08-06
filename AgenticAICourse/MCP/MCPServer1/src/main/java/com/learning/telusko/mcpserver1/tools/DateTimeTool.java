package com.learning.telusko.mcpserver1.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import org.springframework.ai.tool.annotation.Tool;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class DateTimeTool {

    @Tool(description =  "Get current date and time")
    public String getCurrentDateTime(){

        System.out.println("default time zone");
        //return java.time.LocalDateTime.now().toString();
        return ZonedDateTime.now().toString();
    }

    @Tool(description =  "Get current date and time for user's time zone")
    public String getZonedCurrentDateTime(String timeZone){

        System.out.println("default time zone");
        //return java.time.LocalDateTime.now().toString();
        return ZonedDateTime.now(ZoneId.of(timeZone)).toString();
    }

    @Tool(description =  "Get current date and time for user's time zone")
    public String getZonedCurrentDateTime2(String timeZone){

        System.out.println("default time zone");
        //return java.time.LocalDateTime.now().toString();
        return ZonedDateTime.now(ZoneId.of(timeZone)).toString();
    }
}

/**
 * Tools having same method name but different description :  gave an error
 * Tools having same description but different method name: no error
 */
