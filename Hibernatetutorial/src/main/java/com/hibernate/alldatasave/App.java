package com.hibernate.alldatasave;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.byannotation.Computer1;


public class App {

	public static void main(String[] args) throws IOException {
		
        Address a = new Address();
        
        // add value in computer
        a.setAid(101);
        a.setCity("Mumbai");
        a.setIscorrect(false);
        a.setRate(77.7);
        a.setStreet("Chembur");
        a.setDate(new Date());
        
        FileInputStream fi = new FileInputStream("C:\\Users\\ADMIN\\OneDrive\\Desktop\\pic.jpg");
        byte[] data = new byte[fi.available()];
        fi.read(data);
        a.setImage(data);
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class);
      
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();

	}
}
