package com.airline.dao;

import java.util.List;


import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airline.entities.Registeration;


public  class RegisterationDaoImpl implements RegisterationDao {
	
	private Session session;
	
	public RegisterationDaoImpl(Session session) {
		super();
		this.session = session;
	}
	

	public void addRegisteration(Registeration robj){
		
		System.out.println(robj);
		
	  try {
		  
		  Transaction tx=session.beginTransaction();
		  session.save(robj);
	      tx.commit();
	      
	      System.out.println(robj);
	      System.out.println("Record inserted into Register table");		
	  }catch(Exception e) {
		  e.printStackTrace();
		  }
	}
	
	public List<Registeration> select()
	 {
		 Transaction tx=session.beginTransaction();
		 Query qobj=session.createQuery("select robj from Registeration robj" );
		 @SuppressWarnings("unchecked")
		 List<Registeration> list=(List<Registeration>)qobj.getResultList();
		 tx.commit();
		 return list;
		 
	 }


    
    @Override
	public void updateRegisteration(int registerationid ) {
		
		     Transaction transaction = session.beginTransaction();
		        try {
		            session.update(registerationid);
		            transaction.commit();
		        } catch (Exception e) {
		            transaction.rollback();
		            e.printStackTrace();
		        }
		    }
		
		
	}


	





