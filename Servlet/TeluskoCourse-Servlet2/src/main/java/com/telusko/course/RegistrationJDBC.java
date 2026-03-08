package com.telusko.course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.telusko.course.util.JDBCUtility;

/**
 * Servlet implementation class RegistrationJDBC
 * 
 * Pre-req: add the mysql jar in Build Path and Deployment Assembly (eclipse IDE)
 * 
 * JDBC inside a servlet
 */

@WebServlet("/RegistrationJDBC")
public class RegistrationJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vname=request.getParameter("vname");
		String vcompany=request.getParameter("vcompany");
		String vcost=request.getParameter("vcost");
		
		System.out.println(vname+", "+vcompany+", "+vcost);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String query="Insert into VaccineDetails (VaccineName, VaccineCompany, VaccineCost) values (?,?,?)";
		PrintWriter writer=response.getWriter();
		
		try {
			conn=JDBCUtility.getDbConnection();
			if(conn!=null)  pstmt=conn.prepareStatement(query);
			if(pstmt!=null) {
				pstmt.setString(1,vname);
				pstmt.setString(2, vcompany);
				pstmt.setInt(3, Integer.parseInt(vcost));
			}
			int rowAffected=pstmt.executeUpdate();
			if(rowAffected!=0) {
				System.out.println("Table is Updated");
				writer.println("Added to vaccine data to the database system");
			}
			else {
				System.out.println("Failed to register");
				writer.println("Failed to register");
			}

			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtility.closeResources(conn, null, pstmt);
				writer.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}	

}

//better way of doing this is creating a pojo class

/* Creating table and inserting data inside table
 * 
 * use testdb;

	CREATE TABLE VaccineDetails (
	    id INT AUTO_INCREMENT PRIMARY KEY,
	    VaccineName VARCHAR(100) NOT NULL ,
	    VaccineCompany VARCHAR(100) NOT NULL UNIQUE,
	    VaccineCost VARCHAR(100) NOT NULL UNIQUE
	);

 */
