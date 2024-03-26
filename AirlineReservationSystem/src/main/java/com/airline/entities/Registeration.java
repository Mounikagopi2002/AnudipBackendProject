package com.airline.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Registeration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int registerationid;
	
	private String username;
	private String password;
	private String address;
	private String email;
	private int contactno;
	private String gender;
	private String age;
	
	
	public int getRegisterationid() {
		return registerationid;
	}
	public void setRegisterationid(int registerationid) {
		this.registerationid = registerationid;
	}
	
	
	public Registeration() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contact) {
		this.contactno = contact;
		
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Registeration [registerationid=" + registerationid + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", email=" + email + ", contactno=" + contactno + ", gender=" + gender
				+ ", age=" + age +  "]";
	}
	

	}
