package com.ty.arsapp.controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.arsapp.dto.Employee;
import com.ty.arsapp.service.impl.EmployeeServiceImp;

@WebServlet(value = "/viewEmployee")
public class ViewEmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();

		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");

		EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
		Employee employee = employeeServiceImp.validateEmployee(email, password);
		if (employee != null) {
			req.setAttribute("employee", employee);
			String role = employee.getRole();
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("view" + role + ".jsp");
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("login.jsp");
		}

	}

}
