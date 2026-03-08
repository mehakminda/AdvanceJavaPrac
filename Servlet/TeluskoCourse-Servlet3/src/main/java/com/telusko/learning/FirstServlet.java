package com.telusko.learning;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Control in first servlet");
		
		//forward vs include
		
		//include
		/*
		 * RequestDispatcher rd= request.getRequestDispatcher("/SecondServlet");
		 * rd.include(request, response); //I want this task to be done with your help,
		 * make sure sure I am the one responsing back to client
		 * response.sendRedirect("/TeluskoCourse-Servlet3/response1.html"); //responding
		 * to client
		 */		
		
		//forward
		/*
		 * rd.forward(request, response); //i am forwarding to the responsibility to respond back to client
		 * //response.sendRedirect("/TeluskoCourse-Servlet3/response1.html");
		 */	
		
		//method2
		request.getServletContext().getRequestDispatcher("/SecondServlet").forward(request, response);
		
		//method3
		/*
		 * ServletContext context = request.getServletContext(); RequestDispatcher
		 * reqDisp= context.getRequestDispatcher("/SecondServlet");
		 * reqDisp.forward(request, response);
		 */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
