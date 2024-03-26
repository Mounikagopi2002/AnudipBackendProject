package com.airline.dao;

import java.util.List;

import com.airline.entities.Admin;

public interface AdminDao {
	
	
	    Admin getAdminById(int adminid);


	    void addAdmin(Admin aobj );

	    void updateAdmin(int adminid);
	    
	    List<Admin> select();

		
	

}
