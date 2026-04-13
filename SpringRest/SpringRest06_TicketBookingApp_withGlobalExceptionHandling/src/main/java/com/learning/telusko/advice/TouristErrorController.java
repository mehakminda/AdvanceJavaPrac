package com.learning.telusko.advice;

import com.learning.telusko.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice //**** tells the controller that I will handle all the exception for you
//we dont mention anywhere else that this class will handle exception from service to controller
//just by this annotation it mean this will handle exception for controller

public class TouristErrorController {

    @ExceptionHandler(Exception.class)// what type of exception is it handling (ie) Exception class
    public ResponseEntity<ErrorDetails> handleExceptionGlobally(Exception e){
        System.out.println("Advice Global Exception handler");
        ErrorDetails error= new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ExceptionHandler(TouristNotFoundException.class)// what type of exception is it handling (ie) Exception class
    public ResponseEntity<ErrorDetails> handleExceptionForTourist(TouristNotFoundException e){
        System.out.println("Advice Tourist Exception handler");
        ErrorDetails error= new ErrorDetails(HttpStatus.NOT_FOUND, e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


}

/**
 * Only positive response will go to the controller all exception will be handled by class having
 * @RestControllerAdvice annotation
 *
 * applicable to all controller class and all controller method
 */

/**
 * This class can handle only TouristNotfound exception not arithmetic exception/ file not found exception ...
 */

/**
 * {
 *     "statusCode": "404 NOT_FOUND",
 *     "msg": "Tourist with id 8 is not found",
 *     "when": "2026-04-12T20:23:59.1181206"
 * }
 */
