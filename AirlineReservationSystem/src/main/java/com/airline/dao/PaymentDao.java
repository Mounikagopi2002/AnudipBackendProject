package com.airline.dao;

import java.util.List;

import com.airline.entities.Payments;

public interface PaymentDao {
	Payments getPaymentById(int payId);
    void addPayment(Payments pobj1);
    void updatePayment(int payid);
    void deletePayment(int payid);
    List<Payments> getAllPayments();
		
    

}
