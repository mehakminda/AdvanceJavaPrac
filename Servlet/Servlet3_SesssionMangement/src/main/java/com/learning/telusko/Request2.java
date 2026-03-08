package com.learning.telusko;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Date;

/**
 * Servlet implementation class Request2
 */
@WebServlet("/Request2")
public class Request2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Request2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("control in 2nd servlet");
		PrintWriter writer = response.getWriter();

		HttpSession session = request.getSession(false);
		
		long creationTime=session.getCreationTime();
		long lastActiveSession=session.getLastAccessedTime();
		writer.println(" Creation Time: "+ new Date(creationTime));
		writer.println(" Last Accessed Time: "+ new Date(lastActiveSession));
		

		if (session != null) {
			writer.println("Attribute retained in session are: ");
			
			  Enumeration<String> en=session.getAttributeNames();
			  while(en.hasMoreElements()) {
				  String vaccineInfo=en.nextElement();
				  
				  writer.println(session.getAttribute(vaccineInfo));
			  
			  }
			 
				/*
				 * writer.println(session.getAttribute("userName"));
				 * writer.println(session.getAttribute("userCity"));
				 * writer.println(session.getAttribute("userPhoneNumber"));
				 */

		} else {
			writer.println("<h2>No session info available for this user <h2>");
		}
		writer.close();
	}

}
