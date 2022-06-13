package com.ty.arsapp.service;

import java.util.List;

import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.User;

public interface BookingService {
	Booking createBooking(Booking booking, int user_id, int flight_id);

	Booking getBookingsById(int id);
	
	List<Booking> getAllBookings();
	
	List<User> getUsersByFlight(int flight_id);

	Booking updateBooking(Booking booking, int id);
	
	Booking updateBookingStatus(Booking booking, int id);

	boolean deleteBooking(int id);

}
