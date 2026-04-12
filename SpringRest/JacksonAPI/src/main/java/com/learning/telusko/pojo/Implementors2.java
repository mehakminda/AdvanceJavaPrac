package com.learning.telusko.pojo;

import java.util.Arrays;
import java.util.List;

public class Implementors2
{
    private Integer id;
    private String name;
    private String city;
    private boolean Active;

    //has-a
    private Course2 course;
    private List<String> skills;
    private String[] hobbies ;

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

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public Course2 getCourse() {
        return course;
    }

    public void setCourse(Course2 course) {
        this.course = course;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Implementors2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", Active=" + Active +
                ", course=" + course +
                ", skills=" + skills +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }
}
