package com.airline.dao;

import com.airline.entities.Passenger;

public interface PassengerDao {
	Passenger getPassengerById(int passengerid);
    void addPassenger(Passenger pobj);
    void updatePassenger(int passengerid);
    void deletePassenger(int passengerid);


}
