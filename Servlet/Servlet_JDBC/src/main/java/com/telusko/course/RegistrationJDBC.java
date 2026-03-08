package com.telusko.course;

import jakarta.servlet.ServletConfig;
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
import com.telusko.course.util.JdbcApp;

/**
 * Servlet implementation class RegistrationJDBC
 */
@WebServlet("/RegistrationJDBC")
public class RegistrationJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Servlet class is loaded...");
	}
       
  
    public RegistrationJDBC() {
        super();
        System.out.println("Servlet class is instantiated...");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init it method");
	}


	public void destroy() {
		System.out.println("Servlet class is destroyed...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vname=request.getParameter("vname");
		String vcompany=request.getParameter("vcompany");
		String vcost=request.getParameter("vcost");
		
		System.out.println(vname+", "+vcompany+", "+vcost);
		
		JdbcApp app=new JdbcApp();
	       app.setVcost(vcost);
	      
	       app.setId(44);
	       app.setVname(vname);
	       app.setvcompany(vcompany);
	       
	       app.registerVaccine();
	       
	       System.out.println("Register invocked");
		

		PrintWriter writer=response.getWriter();
		
	
			int rowAffected=app.getRowAffected();
			if(rowAffected!=0) {
				System.out.println(">> Table is Updated");
				writer.println("Added to vaccine data to the database system");
			}
			else {
				System.out.println("Failed to register");
				writer.println("Failed to register");
			}
		
	}

}

//better way of doing this is creating a pojo class
//do not write jdbc logic inside a servlet container


