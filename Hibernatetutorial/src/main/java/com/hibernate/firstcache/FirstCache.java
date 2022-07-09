package com.hibernate.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Department;
import com.hibernate.onetomany.Empolyee;

public class FirstCache {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empolyee.class).addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Empolyee d1 = session.get(Empolyee.class, 102);
        System.out.println(d1.getEid()+ " " + d1.getEname() + " " + d1.getEsal());
        
        System.out.println("First cache working....");
        
        Empolyee d2 = session.get(Empolyee.class, 102);
        System.out.println(d2.getEid()+ " " + d2.getEname() + " " + d2.getEsal());
		session.close();

		
		/*
		System.out.println("Session closed...");
		Empolyee d3 = session.get(Empolyee.class, 102);
        System.out.println(d3.getEid()+ " " + d3.getEname() + " " + d3.getEsal());
		*/
	}
}
