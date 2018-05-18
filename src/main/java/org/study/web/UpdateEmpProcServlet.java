package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.Employee;
import org.study.dao.EmployeeDaolmpl;
import org.study.dao.EmployeeService;
import org.study.sec.PasswordAuthentication;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/UpdateProc") 
public class UpdateEmpProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeService service = new EmployeeDaolmpl();	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordAuthentication passAuth = new PasswordAuthentication();
		Employee e = new Employee();
		int id = Integer.parseInt(request.getParameter("id"));
		Employee emp = service.listEmployee(id);
		
		if(passAuth.authenticate(request.getParameter("password").toCharArray(), 
				emp.getPassword())) { // 패스워드 인증 성공
			
			e.setId(Integer.parseInt(request.getParameter("id"))); // 이걸 if위로 올린 이유는?
			e.setName(request.getParameter("name"));
			e.setEmail(request.getParameter("email"));
			e.setCountry(request.getParameter("country"));
			
			if(service.updateEmployee(e)) {
				response.sendRedirect("/ListPageEmp?page=1");
			} else {
				request.setAttribute("error", "직원 정보변경에 실패했습니다.");
				request.setAttribute("emp", e);
				request.getRequestDispatcher("/WEB-INF/views/updateform.jsp").forward(request, response);
			}
			
			
		} else {
			request.setAttribute("error", "비밀번호가 틀렸습니다.");
			request.setAttribute("emp", e);
			request.getRequestDispatcher("/WEB-INF/views/updateform.jsp").forward(request, response);
			
		}
	}
}
