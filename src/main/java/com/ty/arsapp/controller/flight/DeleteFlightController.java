package com.ty.arsapp.controller.flight;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.arsapp.dto.Employee;
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.EmployeeServiceImp;
import com.ty.arsapp.service.impl.FlightServiceImp;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/deleteFlight")
public class DeleteFlightController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		HttpSession httpSession = req.getSession();

		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");

		EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
		Employee employee = employeeServiceImp.validateEmployee(email, password);

		if (employee != null) {
			FlightServiceImp flightServiceImp = new FlightServiceImp();
			boolean res = flightServiceImp.deleteFlight(id);
			if (res) {
				resp.sendRedirect("createFlight.jsp");
			}
		} else {
			resp.sendRedirect("viewFlight");
		}
	}

}
