package com.airline.entities;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int passengerid;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="registerationid")
    private Registeration  robj;
	
	
	public Passenger() {
		super();
		
	}

	public int getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}

	public Registeration getRobj() {
		return robj;
	}

	public void setRobj(Registeration robj) {
		this.robj = robj;
	}

	

	@Override
	public String toString() {
		return "Passenger [passengerid=" + passengerid + ", robj=" + robj + "]";
	}
	
}
