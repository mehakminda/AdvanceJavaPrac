package com.learning.telusko.dao;

import org.springframework.stereotype.Repository;

@Repository(value="repo")
public class Dao {
    public Dao(){  //default reference variable-dao
        System.out.println("Dao obj is created");
    }
}
