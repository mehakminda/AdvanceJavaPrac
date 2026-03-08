package com.learning.telusko.dao;

import org.springframework.stereotype.Component;

@Component //this is actually not needed i think
public class Employee {
    private Integer id;
    private String name;
    private String city;
    private double salary;

    public Employee() {
        System.out.println("Employee object is created");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", city=" + city + ", name=" + name + ", salary=" + salary + "]";
    }
}
