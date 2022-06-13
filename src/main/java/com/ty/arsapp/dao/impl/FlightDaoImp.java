package com.ty.arsapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.arsapp.dao.FlightDao;
import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.dto.User;

public class FlightDaoImp implements FlightDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public Flight saveFlight(Flight flight) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(flight);
		entityTransaction.commit();
		return flight;
	}

	@Override
	public List<Flight> getAllFlights() {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public List<Flight> searchFlight(Flight flight) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where (f.departure=?1) and (f.departureDate=?2) and (f.destination=?3) and (f.destinationDate=?4)";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, flight.getDeparture());
		query.setParameter(2, flight.getDepartureDate());
		query.setParameter(3, flight.getDestination());
		query.setParameter(4, flight.getDestinationDate());
		return query.getResultList();
	}

	@Override
	public Flight getFlightById(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		Flight flight = entityManager.find(Flight.class, id);
		return flight;
	}

	@Override
	public Flight updateFlight(Flight flight, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Flight flight2 = entityManager.find(Flight.class, id);
		flight2.setName(flight.getName());
		flight2.setBrand(flight.getBrand());
		flight2.setType(flight.getType());
		flight2.setDeparture(flight.getDeparture());
		flight2.setDestination(flight.getDestination());
		flight2.setTicketCost(flight.getTicketCost());
		flight2.setNumberOfSeats(flight.getNumberOfSeats());
		flight2.setDepartureDate(flight.getDepartureDate());
		flight2.setDepartureTime(flight.getDepartureTime());
		flight2.setDestinationDate(flight.getDestinationDate());
		flight2.setDestinationTime(flight.getDestinationTime());
		flight2.setDay(flight.getDay());

		entityTransaction.begin();
		entityManager.merge(flight2);
		entityTransaction.commit();
		return flight2;
	}

	@Override
	public boolean deleteFlight(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Flight flight = entityManager.find(Flight.class, id);

		if (flight != null) {
			entityTransaction.begin();
			entityManager.remove(flight);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Flight> getAllFlightsByDay(String day) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.day=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, day);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByDeparture(String departure) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.departure=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, departure);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByDepartureDate(String departureDate) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.departureDate=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, departureDate);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByDestination(String destination) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.destination=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, destination);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByDestinationDate(String destinationDate) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.destinationDate=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, destinationDate);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByName(String name) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.name=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, name);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByBrand(String brand) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.brand=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, brand);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByCost(double ticketCost) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.ticketCost=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, ticketCost);
		return query.getResultList();
	}

	@Override
	public List<Flight> getAllFlightsByType(String type) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Flight f where f.type=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, type);
		return query.getResultList();
	}

}
