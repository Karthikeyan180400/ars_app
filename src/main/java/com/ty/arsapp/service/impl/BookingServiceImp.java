package com.ty.arsapp.service.impl;

import java.util.List;

import com.ty.arsapp.dao.impl.BookingDaoImp;
import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.BookingService;

public class BookingServiceImp implements BookingService {
	BookingDaoImp bookingDaoImp = new BookingDaoImp();

	@Override
	public Booking createBooking(Booking booking, int user_id, int flight_id) {
		return bookingDaoImp.createBooking(booking, user_id, flight_id);
	}

	
	
	@Override
	public Booking getBookingsById(int id) {
		return bookingDaoImp.getBookingsById(id);
	}

	@Override
	public List<User> getUsersByFlight(int flight_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking updateBooking(Booking booking, int id) {
		return bookingDaoImp.updateBooking(booking, id);
	}

	@Override
	public Booking updateBookingStatus(Booking booking, int id) {
		return bookingDaoImp.updateBookingStatus(booking, id);
	}

	@Override
	public boolean deleteBooking(int id) {
		return bookingDaoImp.deleteBooking(id);
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingDaoImp.getAllBookings();
	}

}
