package com.learning.telusko.springsecurity05.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
}
