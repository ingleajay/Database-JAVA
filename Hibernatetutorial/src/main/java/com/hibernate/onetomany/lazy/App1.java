package com.hibernate.onetomany.lazy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.Department;
import com.hibernate.onetomany.Empolyee;

public class App1 {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empolyee.class).addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
		Empolyee c = session.get(Empolyee.class,104);
		System.out.println(c.getEid());
		System.out.println(c.getEname());
		
		// lazy loading - we want then then we get department but not directly only one query run 
		// and after writing this below statement then only we can fetch data
//		List<Department> p = c.getDepartment();
//		for(Department i : p) {
//			System.out.println(i.getDid());
//			System.out.println(i.getDname());
//		}
		session.close();

	}

}
