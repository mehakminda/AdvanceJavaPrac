package com.learning.telusko.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;

@Entity(name="Implementers")
public class Implementers {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Temporal(TemporalType.DATE) //kind of data we will be storing, TemporalType.DATE) is an Enum
    @Column(name="date")
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name="time")
    private Date time;

    @Temporal(TemporalType.TIMESTAMP) //means both date and time
    @Column(name="dateAndTime")
    private Date dateAndTime;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public String toString() {
        return "Implementers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", dateAndTime=" + dateAndTime +
                '}';
    }

    public Implementers() {
        System.out.println("Zero Parameterized constructor, Implementer object is created");
    }
}
