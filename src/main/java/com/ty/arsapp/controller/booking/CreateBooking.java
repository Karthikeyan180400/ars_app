package com.ty.arsapp.controller.booking;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.BookingServiceImp;
import com.ty.arsapp.service.impl.FlightServiceImp;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/createBooking")
public class CreateBooking extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int flight_id = Integer.parseInt(req.getParameter("fid"));
		int user_id = Integer.parseInt(req.getParameter("uid"));

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		long phone = Long.parseLong(req.getParameter("phone"));
		String departure = req.getParameter("departure");
		String destination = req.getParameter("destination");
		String departureDate = req.getParameter("departureDate");
		String departureTime = req.getParameter("departureTime");
		String destinationDate = req.getParameter("destinationDate");
		String destinationTime = req.getParameter("destinationTime");
		int numberOfSeats = Integer.parseInt(req.getParameter("seats"));

		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		Booking booking = new Booking();
		booking.setName(name);
		booking.setEmail(email);
		booking.setGender(gender);
		booking.setPhone(phone);
		booking.setDeparture(departure);
		booking.setDestination(destination);
		booking.setNumberOfSeats(numberOfSeats);
		booking.setDepartureDate(departureDate);
		booking.setDepartureTime(departureTime);
		booking.setDestinationDate(destinationDate);
		booking.setDestinationTime(destinationTime);
		booking.setBookingDateTime(LocalDateTime.now());

		Booking booking2 = bookingServiceImp.createBooking(booking, user_id, flight_id);

		if (booking2 != null) {
			booking2.setBooking_status("Confirmed");
			Booking booking3 = bookingServiceImp.updateBookingStatus(booking2, booking2.getId());
			if (booking3 != null) {
				req.setAttribute("booking", booking3);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewBooking.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}

}
