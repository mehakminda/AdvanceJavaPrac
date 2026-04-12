package com.learning.telusko.pojo;

import java.util.ArrayList;
import java.util.List;

public class Implementers {
    private Integer id;
    private String name;
    private String city;
    private String[] teamName;
    private List<String> hobbies = new ArrayList<>();

    public String[] getTeamName() {
        return teamName;
    }

    public void setTeamName(String[] teamName) {
        this.teamName = teamName;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
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

    @Override
    public String toString() {
        return "Implementer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
