package org.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		Cookie ck;
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		if (cookies == null) {
			out.print("Error: You need first logged in!");
			request.getRequestDispatcher("login.html").include(request, response);
			
			return;
		}
		// 추후 maxAge는 검토 필요
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("name")) {
				ck = new Cookie("name", null);
				ck.setMaxAge(0);
				
				response.addCookie(ck);
				
				out.print("You are successfully logged out!");
				
				return;
			}
		}
		
		
	}
}
