package com.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Product p1 = new Product();
		Product p2 = new Product();
		
		c1.setCid(103);
		c1.setCname("Ajay");
		
		c2.setCid(104);
		c2.setCname("Vijay");
		
		p1.setPid(115);
		p1.setPname("Parle G");
		p1.setPrice(50);
		
		p2.setPid(116);
		p2.setPname("Book");
		p2.setPrice(999);
		
		List<Customer> lc = new ArrayList<Customer>();
		List<Product> lp = new ArrayList<Product>();
		
		lc.add(c1);
		lc.add(c2);
		
		lp.add(p1);
		lp.add(p2);
		
		c1.setProducts(lp);
		p2.setCustomers(lc);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Product.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c1);
        session.save(c2);
        session.save(p1);
        session.save(p2);
        tx.commit();
        session.close();
		

	}
}
