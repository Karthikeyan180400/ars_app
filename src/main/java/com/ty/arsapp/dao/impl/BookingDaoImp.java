package com.ty.arsapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.arsapp.dao.BookingDao;
import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.FlightServiceImp;
import com.ty.arsapp.service.impl.UserServiceImp;

public class BookingDaoImp implements BookingDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public Booking createBooking(Booking booking, int user_id, int flight_id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		FlightServiceImp flightServiceImp = new FlightServiceImp();
		Flight flight = flightServiceImp.getFlightById(flight_id);
		double totalCost = booking.getNumberOfSeats() * flight.getTicketCost();

		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.getUser(user_id);
		booking.setTotalCost(totalCost);
		booking.setFlight(flight);
		booking.setUser(user);

		entityTransaction.begin();
		entityManager.persist(booking);
		entityTransaction.commit();

		return booking;
	}

	@Override
	public List<User> getUsersByFlight(int flight_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking updateBookingStatus(Booking booking, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Booking booking2 = entityManager.find(Booking.class, id);
		booking2.setBooking_status(booking.getBooking_status());

		entityTransaction.begin();
		entityManager.merge(booking2);
		entityTransaction.commit();
		return booking2;
	}

	@Override
	public Booking updateBooking(Booking booking, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Booking booking2 = entityManager.find(Booking.class, id);
		booking2.setName(booking.getName());
		booking2.setEmail(booking.getEmail());
		booking2.setGender(booking.getGender());
		booking2.setPhone(booking.getPhone());
		booking2.setDeparture(booking.getDeparture());
		booking2.setDestination(booking.getDestination());
		booking2.setNumberOfSeats(booking.getNumberOfSeats());
		booking2.setDepartureDate(booking.getDepartureDate());
		booking2.setDepartureTime(booking.getDepartureTime());
		booking2.setDestinationDate(booking.getDestinationDate());
		booking2.setDestinationTime(booking.getDestinationTime());
		booking2.setBookingDateTime(booking.getBookingDateTime());

		double totalCost = booking.getNumberOfSeats() * booking2.getFlight().getTicketCost();
		booking2.setTotalCost(totalCost);

		entityTransaction.begin();
		entityManager.merge(booking2);
		entityTransaction.commit();
		return booking2;
	}

	@Override
	public boolean deleteBooking(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Booking booking = entityManager.find(Booking.class, id);

		if (booking != null) {
			entityTransaction.begin();
			entityManager.remove(booking);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Booking> getAllBookings() {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select b from Booking b";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public Booking getBookingsById(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Booking.class, id);
	}

}
