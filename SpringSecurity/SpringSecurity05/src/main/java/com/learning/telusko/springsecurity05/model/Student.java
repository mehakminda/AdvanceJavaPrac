package com.learning.telusko.springsecurity05.model;


public class Student {
    private int id;
    private String name;
    private String techStack;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", techStack='" + techStack + '\'' +
                '}';
    }

    public Student() {
        System.out.println("Non args constructor of student pojo");
    }

    public Student(int id, String name, String techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }
}
