package com.learning.telusko.springsecurity01;


import jakarta.persistence.*;

@Entity
@Table(name = "users2")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Column (name = "is_active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String password, Boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }
}

