package com.test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ThirdServlet() {
        super();
        System.out.println("The servlet is instantiated");
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("The init is instantiated and invoked");
	}


	public void destroy() {
		System.out.println("The app is closed");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Third Servlet</title></head>");
		out.println("<body><h1><marquee>Welcome to out Dynamic App</marquee></h1></body>");
		out.println("</body>");
	    out.close();;
	}

}
