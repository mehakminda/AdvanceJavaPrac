package com.learning.telusko.dao;

import java.util.List;

public interface IStudentDao {

    public StudentTableBo getStudentById(int id);
    public StudentTableBo getStudentById(int id,String city);

    public List<StudentTableBo> getStudents();
}
