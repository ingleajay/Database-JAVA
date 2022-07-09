package com.hibernate.byannotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Computer1 c = new Computer1();
        
        // add value in computer
        
        c.setCid(100);
        c.setCbrand("Lenovo");
        c.setCprice(300000);
        Configuration con = new Configuration().configure("com/hibernate/byannotation/hibernate.cfg.xml").addAnnotatedClass(Computer1.class);
      
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        
        
    }
}
