package com.airline.entities;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminid;
	

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="registerationid")
	
    private Registeration  robj;
	
	public Admin() {
		super();
		
	}

	public Registeration getRobj() {
		return robj;
	}

	public void setRobj(Registeration robj) {
		this.robj = robj;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", robj=" + robj + "]";
	}


}
