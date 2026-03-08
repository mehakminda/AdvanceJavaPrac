package com.learning.telusko;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Request1
 */
@WebServlet("/Request1")
public class Request1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Request1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("control in 1st servlet");
		
		PrintWriter writer=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.isNew()) {
			writer.println("new session created with ID: "+session.getId());
		}
		else {
			writer.println("new session is being used with ID: "+session.getId());
		}
		
		String userName=request.getParameter("uname");
		String userCity=request.getParameter("ucity");
		String userPhoneNumber = request.getParameter("unumber");
		
		System.out.println(userName +" : "+userCity +" : "+ userPhoneNumber);
		
		session.setAttribute("userName", userName);
		session.setAttribute("userCity", userCity);
		session.setAttribute("userPhoneNumber",userPhoneNumber );
		session.setMaxInactiveInterval(60);
		
		request.getRequestDispatcher("/Request2").include(request,response);
		writer.close();
	}



}

 
/*
 * http://localhost:8080/Servlet3_SesssionMangement/Request1?uname=mehak&ucity=Hyd&unumber=76 
 * http://localhost:8080/Servlet3_SesssionMangement/Request2
 */
