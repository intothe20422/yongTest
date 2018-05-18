package org.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/ProfileServlet")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		request.getRequestDispatcher("link.html").include(request, response);
		// 로그인 안된사람.
		if(cookies == null) {
			out.print("Error: You need first logged in!");
			request.getRequestDispatcher("login.html").include(request, response);
			
			return;
		}
		
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("name")) {
				
				out.print("<h2>Welcome to Profile</h2>");
				out.print("Welcome, " + cookies[i].getValue());
				
				return;
			}
		}
		
		System.out.println("Error: Never see....");
	}



}
