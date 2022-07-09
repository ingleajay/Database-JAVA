package com.hibernate.onetomany.cascading;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Department;
import com.hibernate.onetomany.Empolyee;

public class App {
	
	// use cascading- no need store manully dept each time after change - > cascade = CascadeType.ALL in emp class

	public static void main(String[] args) {
		
		Empolyee e = new Empolyee();
		e.setEid(107);
		e.setEname("Vijay");
		e.setEsal(27000);
		
		Department d = new Department();
		d.setDid(119);
		d.setDname("TECH");
		d.setEmpolyee(e);
		
		Department d1 = new Department();
		d1.setDid(200);
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
        tx.commit();
        session.close();

	}

}
