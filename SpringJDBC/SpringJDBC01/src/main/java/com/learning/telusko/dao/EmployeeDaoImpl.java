package com.learning.telusko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("empDao") // we need component + extra feature to connect to Db
public class EmployeeDaoImpl implements IEmployeeDao{

    //a constant
    private static final String SQL_QUERY= "select * from Employee" ;

    List<Employee> empList=null;

    @Autowired
    private DataSource dataSource; //its from sql jar, not specific to spring boot, its generic to jdbc, hibernate...... and can be used anywhere
    // who will inject the connection object by following one of the connection pooling? spring will inject  hikari CP mechanism object

    public EmployeeDaoImpl(){
        System.out.println("EmployeeDaoImpl bean created");
    }

    @Override
    public List<Employee> getTheEmployees() {
        System.out.println("Datasource :"+ dataSource.getClass().getName());
        try{
            Connection conn=dataSource.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(SQL_QUERY);
            ResultSet rs=pstmt.executeQuery();
            empList= new ArrayList();

            while(rs.next()){
                Employee e=new Employee();
                e.setCity(rs.getString("city"));
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("Name"));
                e.setSalary(rs.getDouble("Salary"));
                empList.add(e);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return empList;
    }

}
