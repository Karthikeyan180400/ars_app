package com.ty.arsapp.controller.flight;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.service.impl.FlightServiceImp;

@WebServlet(value = "/createFlight")
public class SaveFlightController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		String type = req.getParameter("type");
		String departure = req.getParameter("departure");
		String destination = req.getParameter("destination");
		double ticketCost = Double.parseDouble(req.getParameter("ticketCost"));
		int numberOfSeats = Integer.parseInt(req.getParameter("numberOfSeats"));
		String departureDate = req.getParameter("departureDate");
		String departureTime = req.getParameter("departureTime");;
		String destinationDate = req.getParameter("destinationDate");
		String destinationTime = req.getParameter("destinationTime");
		String day = req.getParameter("day");
		
		Flight flight = new Flight();
		flight.setName(name);
		flight.setBrand(brand);
		flight.setType(type);
		flight.setDeparture(departure);
		flight.setDestination(destination);
		flight.setTicketCost(ticketCost);
		flight.setNumberOfSeats(numberOfSeats);
		flight.setDepartureDate(departureDate);
		flight.setDepartureTime(departureTime);
		flight.setDestinationDate(destinationDate);
		flight.setDestinationTime(destinationTime);
		flight.setDay(day);
		
		FlightServiceImp flightServiceImp = new FlightServiceImp();
		Flight flight2 = flightServiceImp.saveFlight(flight);
		
		if(flight2 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewFlight");
			requestDispatcher.forward(req, resp);
		}

	}
}
