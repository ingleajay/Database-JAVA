package com.hibernate.alldatafetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.alldatasave.Address;

public class AppGet {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class);
	      
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        // use - get() => 1. object not found - return null 2. used when not sure obj present in db or not
        // 3. if object not present in session cache then hit to db and get obj value
        
        Address a = session.get(Address.class,1);
        System.out.println(a.getCity() + " " + a.getStreet());
        
        
        session.close();
	}
}
