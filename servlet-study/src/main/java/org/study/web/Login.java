package org.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();

		String n = request.getParameter("name");
		String p = request.getParameter("password");
		
		request.getRequestDispatcher("link.html").include(request, response);

		if (p.equals("servlet")) {
			Cookie cookie = new Cookie("name", n);
			cookie.setMaxAge(60 * 1);
			
			out.print("You are successfully logged in!");
			out.print("<br>Welcome, " + n);
			
			response.addCookie(cookie);
		} else {
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
}
