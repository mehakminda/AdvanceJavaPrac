package com.learning.telusko.pojo;

public class Course {
    private Integer cid;
    private String cname;
    private Double price;
    private String courseDuration;

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", price=" + price +
                ", courseDuration='" + courseDuration + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }
}
