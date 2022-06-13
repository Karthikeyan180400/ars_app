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

@WebServlet(value = "/employeeLogin")
public class ValidateEmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
		Employee employee = employeeServiceImp.validateEmployee(email, password);
		if (employee != null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("password", password);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewEmployee");
			requestDispatcher.forward(req, resp);
		}
	}

}
