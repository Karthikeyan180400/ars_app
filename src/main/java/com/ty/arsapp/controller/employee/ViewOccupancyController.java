package com.ty.arsapp.controller.employee;

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
import com.ty.arsapp.dto.Employee;
import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.service.impl.EmployeeServiceImp;
import com.ty.arsapp.service.impl.FlightServiceImp;

@WebServlet(value = "/viewFlightOccupany")
public class ViewOccupancyController extends HttpServlet {
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

		if (employee1 != null) {
			FlightServiceImp flightServiceImp = new FlightServiceImp();
			List<Flight> flights = flightServiceImp.getAllFlights();
			List<Flight> flights2 = new ArrayList<Flight>();
			if (flights.size() > 0) {
				for (Flight flight : flights) {
					List<Booking> bookings = flight.getBookings();
					if (bookings.size() > 0) {
						int occupancies = 0;
						for (Booking booking : bookings) {
							occupancies = occupancies + booking.getNumberOfSeats();
							System.out.println(occupancies);
						}

						flight.setNumberOfSeats(occupancies);
					} else {
						flight.setNumberOfSeats(0);
					}
					flights2.add(flight);
				}
				req.setAttribute("flightOccupancy", flights2);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewFlightOccupancy.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				resp.sendRedirect("viewEmployee");
			}
		} else {
			resp.sendRedirect("login.jsp");
		}
	}

}
