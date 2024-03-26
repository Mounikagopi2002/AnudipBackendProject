package com.airline;

import java.sql.Date;


import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.airline.dao.AdminDao;
import com.airline.entities.Passenger;
import com.airline.dao.AdminDaoImpl;
import com.airline.dao.BookingDao;
import com.airline.dao.BookingDaoImpl;
import com.airline.dao.PassengerDao;
import com.airline.dao.PassengerDaoImpl;
import com.airline.dao.PaymentDao;
import com.airline.dao.PaymentDaoImpl;
import com.airline.dao.RegisterationDao;
import com.airline.dao.RegisterationDaoImpl;
import com.airline.dao.FlightDao;
import com.airline.dao.FlightDaoImpl;
import com.airline.entities.Admin;
import com.airline.entities.Bookings;
import com.airline.entities.Payments;
import com.airline.entities.Registeration;

import com.airline.entities.Flights;


public class Menu {

	Scanner scanner=new Scanner(System.in);
	Session session;	

	PassengerDao passengerDao ;
	AdminDao adminDao; 
	FlightDao flightDao;
	BookingDao bookingdao;
	PaymentDao paymentDao;

	RegisterationDao registerationDao;

	Menu(Session session){
		this.session=session;
		registerationDao=new RegisterationDaoImpl(session);
		passengerDao = new PassengerDaoImpl(session);
		adminDao = new AdminDaoImpl(session);
		flightDao = new FlightDaoImpl(session);
		bookingdao = new BookingDaoImpl(session);
		paymentDao = new PaymentDaoImpl(session);

	}

	private String arrivaltime;


	public void createRegisteration() {

		try {
			System.out.println("***** Registration *****");


			System.out.print("Enter user name: ");
			String username = scanner.next();
			scanner.nextLine();
			System.out.println("Enter email: ");
			String email = scanner.next();
			System.out.println("Enter your password: ");
			String password = scanner.next();
			System.out.println("Enter your address: ");
			String address= scanner.next();
			System.out.println("Enter your contact: ");
			int contact = scanner.nextInt();
			System.out.println("Enter your Gender: ");
			String gender = scanner.next();
			System.out.println("Enter your age: ");
			String age = scanner.next();


			Registeration robj = new Registeration();
			robj.setUsername(username);
			robj.setPassword(password);
			robj.setEmail(email);
			robj.setAddress(address);
			robj.setAge(age);
			robj.setContactno(contact);
			robj.setGender(gender);


			registerationDao.addRegisteration(robj);

			System.out.println(" Registration successful!");


		} catch (Exception e) {
			System.out.println(" Registration failed. Please try again.");
			e.printStackTrace();
		}


	}


	public void adminLogin() {
		System.out.println("*****  LOGIN *****");

		System.out.println("Enter registeration id to find:");
		int registerationId=scanner.nextInt();

		Registeration aobj=session.find(Registeration.class,registerationId);
		if(aobj==null)
			System.out.println("Record not found");
		else {
			System.out.println("reg id:"+aobj.getRegisterationid());

		}
		Admin robj = new Admin();

		robj.setRobj(aobj);

		adminDao.addAdmin(robj);



		if(aobj==null) {
			System.out.println("login failed.try again");
		}else
		{
			System.out.println("Admin login successfull");
		}






	}       	



	public void bookFlight() {


		List<Flights> availableFlights = flightDao.getAllFlights(); // Initialize availableFlights directly
		if (availableFlights == null || availableFlights.isEmpty()) {
			System.out.println("No available flights to book.");
			return;
		}

		// Display available flights
		System.out.println("Available Flights:");
		for (Flights flight : availableFlights) {
			System.out.println(flight.getFlightid() + " - " + flight.getBooking_flight_type());
		}



		System.out.println(" Booking details");


		System.out.print("Enter flight id:");
		int flightid=scanner.nextInt();

		System.out.print("Booking flight type: ");
		scanner.nextLine();
		String booking_flight_type = scanner.nextLine();
		System.out.print("Booking date (YYYY-MM-DD): ");
		String bookingdate = scanner.nextLine();
		System.out.print("Booking time (HH:MM:SS): ");
		String bookingtime = scanner.nextLine();

		System.out.print("Number of ticket bookings:");
		int num_of_tickets=scanner.nextInt();

		// Create a booking object
		Bookings bobj = new Bookings();
		bobj.setBookingDate(bookingdate);
		bobj.setBookingtime(bookingtime);
		bobj.setBookingFlightType(booking_flight_type);
		bobj.setNumofTickets(num_of_tickets);

		//Bookings pobj1 = new Bookings();
		//Passenger bobj1=new Passenger();
		System.out.println("Enter passenger id :");
		int passengerid=scanner.nextInt();

		Passenger pobj=new Passenger();
		bobj.setPobj(pobj);
		Flights fobj=new Flights();
		bobj.setFobj(fobj);

		bookingdao.addBooking(bobj);




		List<Flights> availableSeats = null;
		try {
			availableSeats = flightDao.getAllFlights();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (availableSeats.isEmpty()) {
			System.out.println(" no available Seats to book.");

		}else {
			System.out.println("available Seats are there to book.");
		}

		// Ask admin to select a flight
		System.out.print("Enter flight id to book the flight: ");
		flightid = scanner.nextInt();

		// Check if the selected flight is available
		Flights selectedflight = flightDao.getFlightById(flightid);
		if ( selectedflight == null || !availableFlights.contains( selectedflight)) {
			System.out.println("Invalid flight id or flight not available.");
			return;
		}


		// Add the selected flight to the booking
		Bookings bobj1=new Bookings();
		bobj1.getFlight(selectedflight);



		System.out.println("Booking successful!");
	}

	public void makePayment( int bookingid, String paydate, Double payamount, String paystatus) {
		System.out.println("Enter payment details:");
		System.out.print("Booking ID: ");
		bookingid = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Payment date (YYYY-MM-DD): ");
		paydate = scanner.nextLine();
		System.out.print("Payment amount: ");
		payamount = scanner.nextDouble();
		System.out.print("Payment status: ");
		scanner.nextLine();
		paystatus = scanner.nextLine();


		// Created Payment object
		Payments pobj1 = new Payments();
		pobj1.setPayDate(paydate);
		pobj1.setPayamount(payamount);
		pobj1.setPaystatus(paystatus);

		// Get Booking object by ID
		Bookings bobj = new Bookings();
		if (bobj != null) {
			pobj1.setBobj(bobj);

			// Save payment to database
			paymentDao.addPayment(pobj1);

			System.out.println("Payment successful!");
		} else {
			System.out.println("Booking not found!");
		}
	}



	public void viewPayment() {
		System.out.println("Enter payment id:");
		int payid=scanner.nextInt();

		Payments pobj2 = session.find(Payments.class,payid);
		if(pobj2!=null) {
			System.out.println("Record  found");
			System.out.println("Payment id:"+pobj2.getPayamount());
			System.out.println("Payment Date:"+pobj2.getPayDate());
			System.out.println("Payment Status:"+pobj2.getPaystatus());
			System.out.println("Booking id:"+pobj2.getBobj());
		}
		else {
			System.out.println("Record not found");
		}
	}



	public void viewBookings() {
		System.out.println("Enter booking id:");

		int bookingid=scanner.nextInt();
		Bookings bobj = session.find(Bookings.class,bookingid);
		if(bobj==null)
			System.out.println("Record not found");
		else {
			System.out.println("Booking id:"+bobj.getBookingid());
			System.out.println("booking Date:"+bobj.getBookingDate());
			System.out.println("booking Flight type:"+bobj.getBookingFlightType());
			System.out.println("booking Time:"+bobj.getBookingtime());
			System.out.println("Booking :"+bobj.getNumofTickets());


		}


	}




	public void passengerLogin() {



		System.out.println("*****  LOGIN *****");

		System.out.println("Enter registeration id to find:");
		int registerationId=scanner.nextInt();

		Registeration pobj=session.find(Registeration.class,registerationId);
		if(pobj==null)
			System.out.println("Record not found");
		else {
			System.out.println("Reg id:"+pobj.getRegisterationid());

		}
		Passenger robj = new Passenger();

		robj.setRobj(pobj);

		passengerDao.addPassenger(robj);



		if(pobj==null) {
			System.out.println("login failed.try again");
		}else
		{
			System.out.println("Passenger login successfull");
		}


	}
}






























