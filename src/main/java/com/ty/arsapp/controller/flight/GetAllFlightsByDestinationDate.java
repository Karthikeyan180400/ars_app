package com.ty.arsapp.controller.flight;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.service.impl.FlightServiceImp;

@WebServlet(value = "/getAllFlightsByDestinationDate")
public class GetAllFlightsByDestinationDate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String destinationDate = req.getParameter("destinationDate");
		FlightServiceImp flightServiceImp = new FlightServiceImp();
		List<Flight> flights = flightServiceImp.getAllFlightsByDestinationDate(destinationDate);
		if (flights.size() > 0) {
			req.setAttribute("flightsList", flights);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewFlightsBydestinationDate.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("adminSearchFlights.jsp");
		}
	}

}
