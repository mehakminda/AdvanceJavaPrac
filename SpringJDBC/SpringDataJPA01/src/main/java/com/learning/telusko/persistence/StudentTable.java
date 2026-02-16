package com.learning.telusko.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@id @entity and @table are hibernate annotation
@Entity //map this class to an entity ie a table in the database
@Table(name="students2")
public class StudentTable {
    @Id
    private Integer sid;
    private String sname;
    private Integer sage;
    private String scity;

    public StudentTable() {
        System.out.println("Student BO obj created....");
    }

    @Override
    public String toString() {
        return "StudentTable{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", scity='" + scity + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }
}
