package com.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
	
		Doctor d = new Doctor();
		d.setDid(109);
		d.setDname("Vijay");
		d.setHospitalname("City");
		
		
		Patient p = new Patient();
		p.setPid(111);
		p.setPname("Altamesh");
		p.setPdisease("coldness");
		d.setPatient(p);
		p.setDoctor(d);

		 Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor.class).addAnnotatedClass(Patient.class);
	        SessionFactory sf = con.buildSessionFactory();
	        Session session = sf.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(d);
	        tx.commit();
	        session.close();
	}
}
