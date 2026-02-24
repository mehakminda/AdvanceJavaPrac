package com.learning.telusko.bo;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class JobSeekerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;

    @Lob
    @Column(length=10000) //mention this if the blob sizes are big
    private byte[] image; //BLOB : byte array

    @Lob
    private char[] textFile; //CLOB: character array

    public JobSeekerProfile() {
        System.out.println("Zero params Job seeker constructor");
        //During retrieval, hibernate will create object class of this entity class, so that hibernate can inject data using setters.
        //hibernate creates objects without parameters
    }

    public JobSeekerProfile(String name, String city, byte[] image, char[] textFile) {
        this.name = name;
        this.city = city;
        this.image = image;
        this.textFile = textFile;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public char[] getTextFile() {
        return textFile;
    }

    public void setTextFile(char[] textFile) {
        this.textFile = textFile;
    }

    @Override
    public String toString() {
        return "JobSeekerProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", image=" + Arrays.toString(image) +
                ", textFile=" + Arrays.toString(textFile) +
                '}';
    }
}
