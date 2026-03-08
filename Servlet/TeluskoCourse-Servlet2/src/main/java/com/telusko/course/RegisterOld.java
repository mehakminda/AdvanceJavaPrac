package com.telusko.course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Register
 * 
 * Servlet is invasive technology(force us to extend /implement an in built class or interface) and Spring is non-invasive technology
 */
//@WebServlet("Register")
public class RegisterOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterOld() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Register obj is created");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname=request.getParameter("uname");
		String ucity=request.getParameter("ucity");
		String number=request.getParameter("unumber");
		
		System.out.println("Hello from register servlet");
		PrintWriter writer=response.getWriter();
		writer.println("Hello! "+uname);
		//or one can also use HTML inside printwriter object and display data.
	}

}
