package com.airline.entities;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int payid;
	private String payDate;
	private double payamount;
	private String paystatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bookingid")
	
	private Bookings bobj;

	

	public Bookings getBobj() {
		return bobj;
	}

	public void setBobj(Bookings bobj) {
		this.bobj = bobj;
	}

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPayid() {
		return payid;
	}

	public void setPayid(int payid) {
		this.payid = payid;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public double getPayamount() {
		return payamount;
	}

	public void setPayamount(double payamount) {
		this.payamount = payamount;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	@Override
	public String toString() {
		return "Payments [payid=" + payid + ", payDate=" + payDate + ", payamount=" + payamount + ", paystatus="
				+ paystatus + ", bobj=" + bobj + "]";
	}

	
	

}
