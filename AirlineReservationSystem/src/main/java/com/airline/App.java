package com.airline;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.airline.crud.FlightCrud;
import com.airline.entities.Bookings;
import com.airline.entities.Passenger;
import com.airline.entities.Registeration;

public class App{
		
		
	private static StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

    private static Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

    private static SessionFactory sf = meta.getSessionFactoryBuilder().build();
    private static Session session = sf.openSession();	
	

	public static void main( String[] args )
	
	 {
		try {
		
	    
		
		
		Scanner sc = new Scanner(System.in);
   
	     
	    	 
	    	 
				Menu menu = new Menu(session);
				FlightCrud flightcrud=new FlightCrud(session);
				
				
				int choice;
				int ch;
				
				
				do {
					
					
					System.out.println();
					System.out.println("--------WELCOME TO AIRLINE RESERVATION SYSTEM--------");
					System.out.println("1) Registration");
					System.out.println("2) Admin Log In");
					System.out.println("3) Passenger Log In");
					System.out.println("4) Exit");
					System.out.println("Enter Your Choice:");
					choice = sc.nextInt();
					
					String paydate = null;
					double price = 0;
					String paystatus = null;
					
					int bookingid = 0;
					

					switch (choice) {
					case 1:
						menu.createRegisteration();
						break;
					case 2://menu.adminLogin();
						menu.adminLogin();
						
						System.out.println("1) View flights");
						System.out.println("2) add flight");
						System.out.println("3) view Booked flight");
						System.out.println("4) view Payment");
						System.out.println("5) Back to main menu");
						System.out.println(" Enter your choice:");
						ch = sc.nextInt();
						if (ch == 1 || ch == 2 || ch == 3 || ch == 4) {
							switch (ch) {
							case 1:
								System.out.println("See all flight Details");
								FlightCrud.displayAllFlights();
								System.out.println("Note: note down the flightid to book flight");
								
								break;
							case 2:
								FlightCrud.addFlight();
								break;

							case 3:
								
								menu.viewBookings();
								break;
							case 4:
								//Menu.viewPayments();
								menu.viewPayment();
							    break;
							
							}
						} else if (ch == 5) {
						  break;
						} else {
							System.out.println("Wrong Input!!");
						}
						break;
					case 3:
						menu.passengerLogin();
						
						System.out.println("1) display all flights");
						System.out.println("2) book flight");
						//System.out.println("3) Payment");
						System.out.println("4) Back to main menu");
						System.out.println(" Enter your choice:");
						ch = sc.nextInt();
						if (ch == 1 || ch == 2  ) {
							switch (ch) {
							case 1:
								FlightCrud.displayAllFlights();
								break;
							case 2:
								menu.bookFlight();
								menu.makePayment(bookingid,paydate, price, paystatus);
								break;
							
							}
						}
					  else if (ch == 3) {
					  break;
					} else {
						System.out.println("Wrong Input!!");
					}
					 break;	
					
					case 4:
						
						System.exit(0);
						System.out.println("Thank you for visiting!");
						break;
					default:
						System.out.println("Wrong Input!!");
					}	
					
				}while(choice != 0);
				    
				}
	    	    catch(Exception e) {
	    	    	e.printStackTrace();
	    	    }
	    	    
							
		}
}
		

	

    
	