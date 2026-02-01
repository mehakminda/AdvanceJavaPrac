package com.learning.telusko.dao;

public class CourseInfo {

    private Integer cid;
    private String cName;
    public CourseInfo(){
        System.out.println("Course info zero param constructor");
    }

    //constructor injection
    public CourseInfo(Integer cid, String cName){
        this.cid=cid;
        this.cName=cName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "CourseInfo{" + "cid=" + cid + ", cName='" + cName + '\'' + '}';
    }
}
