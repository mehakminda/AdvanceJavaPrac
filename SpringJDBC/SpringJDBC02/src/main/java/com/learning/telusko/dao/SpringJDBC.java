package com.learning.telusko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJDBC {

    private static final String SQL_Query="Insert into student (id, name,city) values(1,'Mehak','Hyderabad')";
    private static final String SQL_Query2="Insert into course (cid, cName) values(?,?)";
    private static final String DELETE_QUERY="delete from course where cid=?";
    private static final String SELECT_QUERY ="select cid, cname from course where cid=?" ;

    @Autowired
    private JdbcTemplate jdbc; //similar to datasource
    //data source + other options(boiler plate code)
    //takes care of connection pooling and boiler plate code

    //Insert Data
    public void insert(){ //hardcoded sql query
        System.out.println("Implementing class of JDBCTemplate : "+jdbc.getClass().getName());
        jdbc.update(SQL_Query);
    }

    //insert custom Data
    public void insert2(CourseInfo info) { //dynamic query, using a class
        System.out.println("Implementing class of JDBCTemplate : "+jdbc.getClass().getName());
        int rowsAffected=jdbc.update(SQL_Query2,info.getCid(),info.getcName() );
        System.out.println("Rows affected: "+rowsAffected);
    }

    public void deleteById(long id){
        int rowsAffected=jdbc.update(DELETE_QUERY,id);
        System.out.println("Record deleted with id: "+id+", Rows affected: "+rowsAffected);
    }

    //gives an object
    public CourseInfo findByID(long id){

        //method1 - our own implementation of rowMapper
    /*    return jdbc.queryForObject(SELECT_QUERY,(rs,id)->{
           CourseInfo info=new CourseInfo();
           info.setCid(rs.getInt(1));
           info.setcName(rs.getString(2));
           return info;
        });*/

        //method2
        return jdbc.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(CourseInfo.class),id);
        //rowMapper: An functional interface(has only 1 method) used by JdbcTemplate,  which maps the row in the table to the object we have in application
        //this is one of the class(BeanPropertyRowMapper) which implements rowMapper interface

    }


}
