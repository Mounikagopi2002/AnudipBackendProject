package com.airline.dao;

import java.util.List;

import com.airline.entities.Flights;


public interface FlightDao {
	
    Flights getFlightById(int flightid);
		
    void addFlight(Flights fobj);
    void updateFlight(int flightid);
    
    List<Flights> getAllFlights();
	
    void deleteFlight(int flightid);
    void getFlights(Flights selectedflight);


}
