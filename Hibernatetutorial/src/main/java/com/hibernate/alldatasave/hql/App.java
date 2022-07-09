package com.hibernate.alldatasave.hql;

import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.alldatasave.Address;

public class App {

	private static int i;

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class);
	      
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
      
        // use hql - to get all address 
        String query = "from Address";
        Query q = session.createQuery(query);
        
        List<Address> a = q.list();
        for(Address i : a) {
        	System.out.println("City : " + i.getCity());
        	System.out.println("Street : " + i.getStreet());
        	System.out.println("Rate : " + i.getRate());
        }
        
        // write condition on query
        String query1 = "from Address as a where a.city='Delhi' ";
        Query q1 = session.createQuery(query1);
        
        List<Address> a1 = q1.list();
        for(Address i : a1) {
        	System.out.println("City : " + i.getCity());
        	System.out.println("Street : " + i.getStreet());
        	System.out.println("Rate : " + i.getRate());
        }
        
        // take input from user
        String query2 = "from Address as a where a.city=:x ";
        Query q2 = session.createQuery(query2);
        q2.setParameter("x","Mumbai");
        List<Address> a2 = q2.list();
        for(Address i : a2) {
        	System.out.println("City : " + i.getCity());
        	System.out.println("Street : " + i.getStreet());
        	System.out.println("Rate : " + i.getRate());
        }
        
        // write multiple condition
        String query3 = "from Address as a where a.city=:x and a.rate=:y ";
        Query q3 = session.createQuery(query3);
        q3.setParameter("x","Mumbai");
        q3.setParameter("y", 77.7d);
        List<Address> a3 = q3.list();
        for(Address i : a3) {
        	System.out.println("City : " + i.getCity());
        	System.out.println("Street : " + i.getStreet());
        	System.out.println("Rate : " + i.getRate());
        }
        
        // update data 
        
        Transaction tx = session.beginTransaction();
        String query4 = "update Address set city=:c where aid=:d";
        Query q4 = session.createQuery(query4);
        q4.setParameter("c", "Bangolore");
        q4.setParameter("d", 2);
        int r = q4.executeUpdate();
        System.out.println(r + " is updeatd ");
        tx.commit();
        
        // delete data 
        
        Transaction tx1 = session.beginTransaction();
        String query5 = "delete from Address as a where a.city=:c";
        Query q5 = session.createQuery(query5);
        q5.setParameter("c", "Delhi");
        int r1 = q5.executeUpdate();
        System.out.println(r1 + " is deleted ");
        tx1.commit();
        
        //native query:
        String query6 = "select * from road_address";
        NativeQuery qe= session.createSQLQuery(query6);
        
        List<Object[]> aw = qe.list();
        for(Object[] i : aw) {
        	System.out.println("City : " + i[1]);
        	System.out.println("Street : " + i[5]);
        	System.out.println("Rate : " + i[6]);
        }
	}
}
