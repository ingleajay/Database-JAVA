package com.hibernate.alldatafetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.alldatasave.Address;

public class AppLoad {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class);
	      
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        // use - load() => 1. object not found - return exception 2. used when sure obj present in db or not
        // 3. when you try to print then it is hit to db 

        Address a = session.load(Address.class,1);
        System.out.println(a.getCity() + " " + a.getStreet());
        
        
        
        session.close();

	}

}
