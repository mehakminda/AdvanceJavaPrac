package com.learning.telusko.model;

public class Implementors {
    private Integer uid;
   private  String uname;
    private String ucity="Bengaluru";
    private Long unumber;

    public Implementors() {
        System.out.println("Implementors model obj, zero Param constructor");
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public Long getUnumber() {
        return unumber;
    }

    public void setUnumber(Long unumber) {
        this.unumber = unumber;
    }

    @Override
    public String toString() {
        return "Implementors{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", ucity='" + ucity + '\'' +
                ", unumber=" + unumber +
                '}';
    }
}


//variable names must be same as that of the name attribute in input tag