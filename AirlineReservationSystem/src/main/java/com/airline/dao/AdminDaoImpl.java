package com.airline.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.airline.entities.Admin;


public  class AdminDaoImpl implements AdminDao {
	
	
	private final Session session;

    public AdminDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public Admin getAdminById(int adminid) {
        return session.get(Admin.class, adminid);
    }

    
    @Override
    public void addAdmin(Admin aobj) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(aobj);
            transaction.commit();
            System.out.println("Record inserted into Admin table");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateAdmin(int adminid) {
    
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(adminid);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	@Override
	public List<Admin> select() {
		Transaction tx=session.beginTransaction();
		 @SuppressWarnings("rawtypes")
		Query qobj=session.createQuery("select aobj from Admin aobj" );
		 @SuppressWarnings("unchecked")
		 List<Admin> list=(List<Admin>)qobj.getResultList();
		 tx.commit();
		 return list;
	}

	
   
}


	
	


