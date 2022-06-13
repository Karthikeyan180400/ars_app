package com.ty.arsapp.controller.flight;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.FlightServiceImp;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/searchFlight")
public class SearchFlightController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String departure = req.getParameter("departure");
		String departureDate = req.getParameter("departureDate");
		String destination = req.getParameter("destination");
		String destinationDate = req.getParameter("destinationDate");

		Flight flight = new Flight();
		flight.setDeparture(departure);
		flight.setDepartureDate(departureDate);
		flight.setDestination(destination);
		flight.setDestinationDate(destinationDate);

		FlightServiceImp flightServiceImp = new FlightServiceImp();
		List<Flight> flights = flightServiceImp.searchFlight(flight);

		HttpSession httpSession = req.getSession();
		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");
		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.validateUser(email, password);
		if (user != null) {
			if (flights.size() > 0) {
				req.setAttribute("flightslist", flights);
				req.setAttribute("user", user);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewSearchFlight.jsp");
				requestDispatcher.forward(req, resp);
			}
		}

	}
}
