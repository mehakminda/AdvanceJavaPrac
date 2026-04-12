package com.learning.telusko.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

//pojo
@Data
@AllArgsConstructor
public class ErrorDetails {
    private HttpStatus statusCode;
    private String msg;
    private LocalDateTime when; //when exception occured.


}
