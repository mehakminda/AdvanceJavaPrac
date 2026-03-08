package com.learning.telusko.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//This is a entity/model/pojo class which will be mapped to a table in database
//All the below annotation are coming from JPA
//ORM: Object-Relational Mapping :  It acts as a bridge between object-oriented code (e.g., Python, Java) and relational database tables.
//By using ORM, developers can interact with databases using code objects instead of writing raw SQL queries

@Entity //states that this class is mapped to a table in database
@Table(name="students")
public class Student {

    @Id //primary key
    @Column(name="sid") //corresponding column in the table
     private Integer id;

    @Column(name="sname")
    private String name;

    @Column(name="scity")
    private String city;

    @Column(name="sage")
    private Integer age;

    //Hibernate expects a zero parameterised constructor
    public Student() {
        System.out.println("No-args constructor required for internal use of hibernate");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
