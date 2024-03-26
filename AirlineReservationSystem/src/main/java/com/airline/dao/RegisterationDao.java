package com.airline.dao;

import java.util.List;

import com.airline.entities.Registeration;

public interface RegisterationDao {
	
     void addRegisteration(Registeration robj);
	List<Registeration> select();
	void updateRegisteration(int registerationid);


}
