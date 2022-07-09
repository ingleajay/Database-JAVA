package com.hibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {

	public static void main(String[] args) {
		
		Empolyee e = new Empolyee();
		e.setEid(104);
		e.setEname("Vijay");
		e.setEsal(27000);
		
		Department d = new Department();
		d.setDid(116);
		d.setDname("TECH");
		d.setEmpolyee(e);
		
		Department d1 = new Department();
		d1.setDid(117);
		d1.setDname("Acc");
		d1.setEmpolyee(e);
		
		List<Department> a = new ArrayList<Department>();
		a.add(d);
		a.add(d1);
		e.setDepartment(a);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empolyee.class).addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e);
        session.save(d);
        session.save(d1);
        tx.commit();
        session.close();
	}

}
