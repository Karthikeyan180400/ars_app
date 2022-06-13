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
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.EmployeeServiceImp;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/updateEmployee")
public class UpdateEmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		String email1 = (String) httpSession.getAttribute("email");
		String password1 = (String) httpSession.getAttribute("password");

		EmployeeServiceImp employeeServiceImp1 = new EmployeeServiceImp();
		Employee employee1 = employeeServiceImp1.validateEmployee(email1, password1);

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String role = req.getParameter("role");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		long phone = Long.parseLong(req.getParameter("phone"));

		if (employee1 != null) {
			Employee employee = new Employee();
			employee.setName(name);
			employee.setRole(role);
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setGender(gender);
			employee.setPhone(phone);

			EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
			Employee employee2 = employeeServiceImp.updateEmployee(employee, id);
			if (employee2 != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, resp);

			} else {
				resp.sendRedirect("login.jsp");
			}
		}
	}

}
