package com.airline.entities;

import java.sql.Date;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bookings {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingid;
	private int numofTickets;
	//private int totalprice;
	private String bookingDate;
	private String bookingFlightType;
	private String bookingtime;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passengerid")
	private Passenger pobj;
	


	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="flightid") 
	
	private Flights fobj;

	public Flights getFobj() {
		return fobj;
	}

	public void setFobj(Flights fobj) {
		this.fobj = fobj;
	}

	public Bookings() {
		super();
		
	}


	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getNumofTickets() {
		return numofTickets;
	}

	public void setNumofTickets(int numofTickets) {
		this.numofTickets = numofTickets;
	}
	public String getBookingFlightType() {
		return bookingFlightType;
	}

	public void setBookingFlightType(String bookingFlightType) {
		this.bookingFlightType = bookingFlightType;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingtime() {
		return bookingtime;
	}

	public void setBookingtime(String bookingtime) {
		this.bookingtime = bookingtime;
	}
	
	public Passenger getPobj() {
		return pobj;
	}

	public void setPobj(Passenger pobj) {
		this.pobj = pobj;
	}

	@Override
	public String toString() {
		return "Bookings [bookingid=" + bookingid + ", numofTickets=" + numofTickets  
				+ ", bookingDate=" + bookingDate + ", bookingFlightType=" + bookingFlightType + ", bookingtime="
				+ bookingtime +  ", pobj=" + pobj + ",  fobj=" + fobj + "]";
	}

	public void getFlight(Flights selectedflight) {
		// TODO Auto-generated method stub
		
	}


	
	public void setBobj(Bookings booking) {
		// TODO Auto-generated method stub
		
	}

	public Registeration getRegisteration() {
		// TODO Auto-generated method stub
		return null;
	}


}
