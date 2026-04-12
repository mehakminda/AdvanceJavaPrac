package com.learning.telusko.exception;

public class TouristNotFoundException extends RuntimeException{
    public TouristNotFoundException(String msg) {
        super(msg);
    }
}
