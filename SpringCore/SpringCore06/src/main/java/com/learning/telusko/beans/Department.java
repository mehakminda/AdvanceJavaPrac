package com.learning.telusko.beans;

public class Department {
    private Integer depNo;
    private String depName;

    public Department(Integer depNo, String depName) {
        super();
        this.depNo = depNo;
        this.depName = depName;
        System.out.println("Department Object Created");
    }

    @Override
    public String toString() {
        return "Department{" +
                "depNo=" + depNo +
                ", depName='" + depName + '\'' +
                '}';
    }
}
