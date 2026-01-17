package com.learning.telusko.beans;

public class Alpha {

    private Beta beta;

    public void setBeta(Beta beta) {
        this.beta = beta;
        System.out.println("setBeta() invoked and injected Beta in  Alpha object");
    }

    public Alpha() {
        System.out.println("Alpha Bean Created");
    }

    public Alpha(Beta beta) {
        this.beta = beta;
        System.out.println("Alpha Bean Created using parameterized constructor");
    }
}
