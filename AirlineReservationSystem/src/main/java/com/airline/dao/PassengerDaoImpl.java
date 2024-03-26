package com.airline.dao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airline.entities.Passenger;
import com.airline.entities.Registeration;


public  class PassengerDaoImpl implements PassengerDao {
	
	private Session session;
	
	public PassengerDaoImpl(Session session) {
		super();
		this.session = session;
	}
	

	public void addPassenger(Passenger pobj){
		
	  try {
		  
		  Transaction tx=session.beginTransaction();
		  session.save(pobj);
	      tx.commit();
	      
	      System.out.println(pobj);
	      System.out.println("Record inserted into Passenger table");		
	  }catch(Exception e) {
		  e.printStackTrace();
		  }
	}
	
	public void updatePassenger(int passengerid,Registeration robj){
	     
	    try {
	    	
	    	
			Passenger pobj=session.find(Passenger.class,passengerid);
	        if(pobj==null)
	        	System.out.println("Record not found");
	        else {
	        	pobj.setRobj(robj);
	        	
	        	
	        	Transaction tx=session.beginTransaction();
	        	session.merge(pobj);
	        	tx.commit();
	        	
	        	System.out.println(pobj);
	        	System.out.println("Record updated into Passenger table");
	        }
	    }catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }
	
	 public List<Passenger> select()
	 {
		 Transaction tx=session.beginTransaction();
		 Query qobj=session.createQuery("select pobj from Passenger pobj" );
		 @SuppressWarnings("unchecked")
		 List<Passenger> list=(List<Passenger>)qobj.getResultList();
		 tx.commit();
		 return list;
	 }




	@Override
	public Passenger getPassengerById(int passengerId) {
		// TODO Auto-generated method stub
		return null;
	}


	


	


	@Override
	public void deletePassenger(int passengerId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updatePassenger(int passengerid) {
		// TODO Auto-generated method stub
		
	}



}
