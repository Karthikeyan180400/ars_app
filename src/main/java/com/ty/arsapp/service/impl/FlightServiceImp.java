package com.ty.arsapp.service.impl;

import java.util.List;

import com.ty.arsapp.dao.impl.FlightDaoImp;
import com.ty.arsapp.dto.Flight;
import com.ty.arsapp.service.FlightService;

public class FlightServiceImp implements FlightService {
	FlightDaoImp flightDaoImp = new FlightDaoImp();

	@Override
	public Flight saveFlight(Flight flight) {
		return flightDaoImp.saveFlight(flight);
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightDaoImp.getAllFlights();
	}

	@Override
	public List<Flight> searchFlight(Flight flight) {
		return flightDaoImp.searchFlight(flight);
	}

	@Override
	public Flight getFlightById(int id) {
		return flightDaoImp.getFlightById(id);
	}

	@Override
	public Flight updateFlight(Flight flight, int id) {
		return flightDaoImp.updateFlight(flight, id);
	}

	@Override
	public boolean deleteFlight(int id) {
		return flightDaoImp.deleteFlight(id);
	}

	@Override
	public List<Flight> getAllFlightsByDay(String day) {
		return flightDaoImp.getAllFlightsByDay(day);
	}

	@Override
	public List<Flight> getAllFlightsByDeparture(String departure) {
		return flightDaoImp.getAllFlightsByDeparture(departure);
	}

	@Override
	public List<Flight> getAllFlightsByDepartureDate(String departureDate) {
		return flightDaoImp.getAllFlightsByDepartureDate(departureDate);
	}

	@Override
	public List<Flight> getAllFlightsByDestination(String destination) {
		return flightDaoImp.getAllFlightsByDestination(destination);
	}

	@Override
	public List<Flight> getAllFlightsByDestinationDate(String destinationDate) {
		return flightDaoImp.getAllFlightsByDestinationDate(destinationDate);
	}

	@Override
	public List<Flight> getAllFlightsByName(String name) {
		return flightDaoImp.getAllFlightsByName(name);
	}

	@Override
	public List<Flight> getAllFlightsByBrand(String brand) {
		return flightDaoImp.getAllFlightsByBrand(brand);
	}

	@Override
	public List<Flight> getAllFlightsByCost(double ticketCost) {
		return flightDaoImp.getAllFlightsByCost(ticketCost);
	}

	@Override
	public List<Flight> getAllFlightsByType(String type) {
		return flightDaoImp.getAllFlightsByType(type);
	}

}
