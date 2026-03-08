package com.test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 * 
 * Access: http://localhost:8080/TeluskoCourse-Servelet1/FirstServlet
 *       protocol IP address port project                 controller
 */
//@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static{
		System.out.println("Servlet is loaded...");
	}

    public FirstServlet() {
        super();
        System.out.println("The servlet is instantiated");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init is instantiated and invoked");
	}


	public void destroy() {
		System.out.println("At the end to close app");
	}

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Method to handle requets and response");
	}

}
