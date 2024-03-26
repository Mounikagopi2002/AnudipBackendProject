package com.airline.crud;

import com.airline.dao.FlightDao;
import com.airline.dao.FlightDaoImpl;
import com.airline.entities.Flights;

import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;



public class FlightCrud {


	Session session;


	static FlightDao flightDao;

	public FlightCrud(Session session) {
		this.session = session;

		flightDao=new FlightDaoImpl(session);

	}


	public static void addFlight() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter flight id:");
		int flightid=scanner.nextInt();
		System.out.println("Enter flight name:");
		scanner.nextLine();
		String flightname=scanner.nextLine();
		System.out.println("Enter flight type:");
		String booking_flight_type=scanner.nextLine();
		System.out.println("Enter flight available seats:");
		int  availableseats=scanner.nextInt();
		System.out.println("Enter flight price:");
		double price=scanner.nextDouble();
		System.out.println("Enter flight departure place:");
		scanner.nextLine();
		String departureplace=scanner.nextLine();
		System.out.println("Enter flight arrival place:");
		String arrivalplace=scanner.nextLine();
		System.out.println("Enter flight Date:");
		String date=scanner.nextLine();
		// Prompt the user to enter time including AM/PM
		System.out.print("Enter departure time : ");
		String departuretime = scanner.nextLine();
		System.out.print("Enter arrival time : ");
		String arrivaltime = scanner.nextLine();

		Flights fobj = new Flights();
		

		fobj.setFlightid(flightid);
		fobj.setFlightName(flightname);
		fobj.setBooking_flight_type(booking_flight_type);
		fobj.setDate(date);
		fobj.setArrivalplace(arrivalplace);
		fobj.setDepartureplace(departureplace);
		fobj.setDeparturetime(departuretime);
		fobj.setArrivaltime(arrivaltime);
		fobj.setAvailableseats(availableseats);
		fobj.setPrice(price);

		flightDao.addFlight(fobj);


		System.out.println("Flight added successfully!");



		System.out.println("Enter flight id:");
		int flightid1=scanner.nextInt();
		System.out.println("Enter flight name:");
		scanner.nextLine();
		String flightname1=scanner.nextLine();
		System.out.println("Enter flight type:");
		String booking_flight_type1=scanner.nextLine();
		System.out.println("Enter flight capacity:");
		int availableseats1=scanner.nextInt();
		System.out.println("Enter flight price:");
		double price1=scanner.nextDouble();
		System.out.println("Enter flight departure place:");
		scanner.nextLine();
		String departureplace1=scanner.nextLine();
		System.out.println("Enter flight arrival place:");
		String arrivalplace1=scanner.nextLine();
		System.out.println("Enter flight Date:");
		String date2=scanner.nextLine();
		// Prompt the user to enter time including AM/PM
		System.out.print("Enter departure time : ");
		String departuretime1 = scanner.nextLine();

		System.out.print("Enter arrival time : ");
		String arrivaltime1 = scanner.nextLine();



		Flights fobj1 = new Flights();


		fobj1.setFlightid(flightid1);
		fobj1.setFlightName(flightname1);
		fobj1.setBooking_flight_type(booking_flight_type1);
		fobj1.setDate(date2);
		fobj1.setArrivalplace(arrivalplace1);
		fobj1.setDepartureplace(departureplace1);
		fobj1.setDeparturetime(departuretime1);
		fobj1.setArrivaltime(arrivaltime1);
		fobj1.setAvailableseats(availableseats);
		fobj1.setPrice(price1);
		flightDao.addFlight(fobj1);


		System.out.println("Flight added successfully!");




	}



	public void updateFlight(int flightid, String booking_flight_type,int capacity) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter flight id to update: ");
		flightid = scanner.nextInt();
		scanner.nextLine();

		Flights flight = flightDao.getFlightById(flightid);
		if (flight == null) {
			System.out.println("flight not found!");
			return;
		}

		System.out.println("Enter new details for flight id " + flightid + ":");
		System.out.print("flight type (leave blank to keep existing): ");
		booking_flight_type = scanner.nextLine();
		if (!booking_flight_type.isEmpty()) {
			flight.setBooking_flight_type(booking_flight_type);
		}
		System.out.print(" flight total price (0 to keep existing): ");
		double price = scanner.nextDouble();
		scanner.nextLine();
		if (price != 0) {
			flight.setPrice(price);
		}
		System.out.print("capacity (leave blank to keep existing): ");
		capacity = scanner.nextInt();

		List<Flights> availableSeats = null;
		try {
			availableSeats = flightDao.getAllFlights();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (availableSeats.isEmpty()) {
			System.out.println("No available flights to book.");
			return;
		}
		
		flightDao.updateFlight(flightid);
		System.out.println("flight updated successfully!");
	}

	public void deleteFlight(int flightid) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter room number to delete: ");
		int flightid1 = scanner.nextInt();
		scanner.nextLine();

		Flights flight = flightDao.getFlightById(flightid1);
		if (flight == null) {
			System.out.println("flight not found!");
			return;
		}

		flightDao.deleteFlight(flightid1);
		System.out.println("flight deleted successfully!");
	}

	public static void displayAllFlights() {
		List<Flights> flight = flightDao.getAllFlights();
		if (flight == null || flight.isEmpty()) {
			System.out.println("No flights available.");
		} else {
			System.out.println("Available flights:");
			for (Flights flight1 :flight ) {
				System.out.println(flight1.getFlightid() + "  " + flight1.getFlightName() + "   " +flight1.getBooking_flight_type()+"  "+ flight1.getPrice()+" "+flight1.getAvailableseats()+"  "+flight1.getArrivaltime()+"  "+flight1.getDeparturetime());
			}
		}
	}

}



