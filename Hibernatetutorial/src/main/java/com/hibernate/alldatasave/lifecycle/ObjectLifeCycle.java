package com.hibernate.alldatasave.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.alldatasave.Address;

public class ObjectLifeCycle {

	public static void main(String[] args) {
		
		// transient, persient, Detach, removed
		
		// creating object
		Address a = new Address();
		a.setAid(101);
        a.setCity("Mumbai");
        a.setIscorrect(false);
        a.setRate(77.7);
        a.setStreet("Chembur");
        // Addresss - Transient state
        
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        // persiesient - session, database
       // session.save(a);
       // a.setCity("Delhi");
        System.out.println(a.getCity());
        
        
        // remove
        Address a1 = session.get(Address.class,1);
        session.delete(a1);;
       System.out.println(a1.getCity());
        tx.commit();
  
        session.close();
        // address- detached state
       // a.setCity("Jack");
       
        
        
	}

}
