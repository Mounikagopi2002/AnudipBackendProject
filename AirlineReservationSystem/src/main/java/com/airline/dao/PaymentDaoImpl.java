package com.airline.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airline.entities.Payments;


public  class PaymentDaoImpl implements PaymentDao {
	
	private final Session session;

    public PaymentDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public Payments getPaymentById(int paymentid) {
        return session.get(Payments.class, paymentid);
    }

    public void addPayment(Payments pobj1) {
    	System.out.println(pobj1);
		
  	  try {
  		  
  		  Transaction tx=session.beginTransaction();
  		  session.save(pobj1);
  	      tx.commit();
  	      
  	      System.out.println(pobj1);
  	      System.out.println("Record inserted into Payment table");		
  	  } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    @Override
    public void updatePayment(int payid) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(payid);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deletePayment(int paymentid) {
        Transaction transaction = session.beginTransaction();
        try {
            Payments payment = session.get(Payments.class, paymentid);
            if (payment != null) {
                session.delete(payment);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Payments> getAllPayments() {
          return session.createQuery("FROM Payment", Payments.class).list();
    }

	


}
