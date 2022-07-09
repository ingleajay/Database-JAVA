package com.hibernateproject.byxml;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Computer c = new Computer();
        
        // add value in computer
        
        c.setCid(103);
        c.setCbrand("Dell");
        c.setCprice(100000);
        
        Configuration config = new Configuration();
        config.configure("/com/hibernateproject/byxml/hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        
    }
}
