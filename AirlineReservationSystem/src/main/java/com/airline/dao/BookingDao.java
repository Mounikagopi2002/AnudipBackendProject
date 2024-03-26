package com.airline.dao;

import java.sql.Time;
import java.util.List;

import com.airline.entities.Bookings;

public interface BookingDao {
    Bookings getBookingById(int bookingid);
    void addBooking(Bookings bobj);
	List<Bookings> getAllBookings();
	void bookFlight(int bookingid, int numofTickets, int totalprice, String bookingDate, Time bookingtime,String status);
    
	void deleteBooking(int bookingid);
	void updateBooking(int bookingid);
	void bookFlight(Bookings bobj, int bookingid);
   
	
	


}
