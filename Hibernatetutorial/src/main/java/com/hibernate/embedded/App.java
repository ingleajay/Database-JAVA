package com.hibernate.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {

	public static void main(String[] args) {
		
		Student s = new Student();
		s.setSid(101);
		s.setSname("Ajay");
		s.setScity("Mumbai");
		
		
		Certificate c = new Certificate();
		c.setCname("Java");
		c.setCprice(1500);
		s.setCertificate(c);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
	      
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
		
		

	}

}
