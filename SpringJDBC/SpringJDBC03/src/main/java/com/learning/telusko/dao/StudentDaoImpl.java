package com.learning.telusko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dao")
public class StudentDaoImpl implements IStudentDao{
    @Autowired //spring will inject the jdbc template object, using the connection pooling mechanism of hikari cp.
    private JdbcTemplate jdbc;

    private static final  String SELECT_QUERY="select sid,sname,scity,sage from students2 where sid=?";
    private static final  String SELECT_QUERY2="select sid,sname,scity,sage from students2 where sid=? and scity=?";
    private static final  String SELECT_QUERY3="select sid,sname,scity,sage from students2 ";

    //method1 of pass rowMapper is implementing a rowMapper interface
/*    public static class RowMapperImp implements RowMapper<StudentTableBo>
    {
        public StudentTableBo mapRow(ResultSet rs, int rowNum){
        .....
            return null;
        }
    }
    // pass new RowMapperImp() as argument in queryForObject method

     @Override
    public StudentTableBo getStudentById(int id) {
        jdbc.queryForObject(SELECT_QUERY, new RowMapperImp() , id);
        return null;
    }
    */


    //method2
   /* @Override
    public StudentTableBo getStudentById(int id) {
        return jdbc.queryForObject(SELECT_QUERY, new RowMapper<StudentTableBo>() {
            public StudentTableBo mapRow(ResultSet rs, int rowNum) throws SQLException {
                StudentTableBo bo=new StudentTableBo();
                bo.setSid(rs.getInt(2));
                bo.setSname(rs.getString(4));
                bo.setScity(rs.getString("scity"));
                return bo;
            }
        }, id);
    }*/

    //method3 - using lamba
   @Override
    public StudentTableBo getStudentById(int id) {
        return jdbc.queryForObject(SELECT_QUERY, ( rs,  rowNum) ->{
                StudentTableBo bo=new StudentTableBo();
                bo.setSid(rs.getInt("sid"));
                bo.setSname(rs.getString("sname"));
                bo.setScity(rs.getString("scity"));
                bo.setSage(rs.getInt("sage"));
                return bo;
        }, id);
    }
    @Override
    public StudentTableBo getStudentById(int id, String city) {
        return jdbc.queryForObject(SELECT_QUERY2, ( rs,  rowNum) ->{
            StudentTableBo bo=new StudentTableBo();
            bo.setSid(rs.getInt("sid"));
            bo.setSname(rs.getString("sname"));
            bo.setSage(rs.getInt("sage"));
            bo.setScity(rs.getString("scity"));
            return bo;
        }, id,city);
    }

    @Override
    public List<StudentTableBo> getStudents() {
        return jdbc.query(SELECT_QUERY3, ( rs,  rowNum) ->{
            StudentTableBo bo=new StudentTableBo();
            bo.setSid(rs.getInt("sid"));
            bo.setSname(rs.getString("sname"));
            bo.setSage(rs.getInt("sage"));
            bo.setScity(rs.getString("scity"));
            return bo;
        });
    }
}

/**
 * DAO is the persistence layer performing persistence operation
 */