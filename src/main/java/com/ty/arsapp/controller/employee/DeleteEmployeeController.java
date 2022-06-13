package com.ty.arsapp.controller.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.arsapp.service.impl.EmployeeServiceImp;

@WebServlet(value = "/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
		boolean res = employeeServiceImp.deleteEmployee(id);
		if(res) {
			resp.sendRedirect("welcome.jsp");
		}
	}

}
