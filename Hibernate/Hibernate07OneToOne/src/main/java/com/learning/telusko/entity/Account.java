package com.learning.telusko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//by default the table name is the class name and field name is the column name of table
@Entity
public class Account {

    @Id //primary key
    private String accNo;

    private String name;

    private String accType;

    public Account(){
        System.out.println("Account class object is created by hibernate, zero param constructor");
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNo='" + accNo + '\'' +
                ", name='" + name + '\'' +
                ", accType='" + accType + '\'' +
                '}';
    }
}
