package com.ty.arsapp.controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.arsapp.dto.Employee;
import com.ty.arsapp.service.impl.EmployeeServiceImp;

@WebServlet(value = "/createEmployee")
public class SaveEmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String role = req.getParameter("role");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		long phone = Long.parseLong(req.getParameter("phone"));

		Employee employee = new Employee();
		employee.setName(name);
		employee.setRole(role);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setGender(gender);
		employee.setPhone(phone);

		EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
		Employee employee2 = employeeServiceImp.saveEmployee(employee);
		if (employee2 != null && employee2.getRole() != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);

		} else {
			resp.sendRedirect("createEmployee.jsp");
		}

	}

}
