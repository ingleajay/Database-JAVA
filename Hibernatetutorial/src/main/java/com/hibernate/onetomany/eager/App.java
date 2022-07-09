package com.hibernate.onetomany.eager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Department;
import com.hibernate.onetomany.Empolyee;

public class App {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empolyee.class).addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
		Empolyee c = session.get(Empolyee.class,104);
		System.out.println(c.getEid());
		System.out.println(c.getEname());
		
		// eager - it's giving you direct one query like join emp and depart both 
		List<Department> p = c.getDepartment();
		for(Department i : p) {
			System.out.println(i.getDid());
			System.out.println(i.getDname());
		}
		session.close();

	}

}
