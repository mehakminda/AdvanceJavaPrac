package com.learning.telusko.kafkaproducer1.model;



public class Course {
    private String courseName;
    private String courseID;
    private String trainer;
    private double price;

    public Course(String courseName, String courseID, String trainer, double price) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.trainer = trainer;
        this.price = price;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseID='" + courseID + '\'' +
                ", trainer='" + trainer + '\'' +
                ", price=" + price +
                '}';
    }
}
