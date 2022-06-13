package com.ty.arsapp.dao;

import java.util.List;

import com.ty.arsapp.dto.Flight;

public interface FlightDao {
	Flight saveFlight(Flight flight);

	Flight getFlightById(int id);

	List<Flight> getAllFlights();

	List<Flight> getAllFlightsByDay(String day);

	List<Flight> getAllFlightsByDeparture(String departure);

	List<Flight> getAllFlightsByDepartureDate(String departureDate);

	List<Flight> getAllFlightsByDestination(String destination);

	List<Flight> getAllFlightsByDestinationDate(String destinationDate);

	List<Flight> getAllFlightsByName(String name);
	
	List<Flight> getAllFlightsByBrand(String brand);

	List<Flight> getAllFlightsByCost(double ticketCost);

	List<Flight> getAllFlightsByType(String type);

	List<Flight> searchFlight(Flight flight);

	Flight updateFlight(Flight flight,int id);

	boolean deleteFlight(int id);

}
