package com.learning.telusko.beans;

public class Beta {
    private Alpha alpha;

    public void setalpha(Alpha alpha) {
        this.alpha = alpha;
        System.out.println("setAlpha() invoked and injected alpha in  Beta object");
    }

    public Beta() {
        System.out.println("Beta Bean Created");
    }

    public Beta(Alpha alpha) {
        this.alpha = alpha;
    }
}
