package com.ty.arsapp.controller.booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/viewBookingByUser")
public class ViewBookingByUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();

		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");

		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.validateUser(email, password);
		if (user != null) {
			req.setAttribute("user", user);
			List<Booking> bookings = new ArrayList<Booking>();

			for (Booking booking : user.getBookings()) {
				bookings.add(booking);
			}
			req.setAttribute("bookings", bookings);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewBookingByUser.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
