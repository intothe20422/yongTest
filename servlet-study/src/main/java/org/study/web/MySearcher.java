package org.study.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MySearcher")		
public class MySearcher extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		String search = req.getParameter("name");
		
		String searchUrl = URLEncoder.encode(new String(search), "UTF-8");  
		System.out.println(search);
		
		res.sendRedirect("https://www.google.com/search?q=" + searchUrl);
	}
}
