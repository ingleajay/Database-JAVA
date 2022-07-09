package com.todo.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.loggeduser.User;
import com.todo.Todo;

public class FactoryProvider {

	public static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		if(factory == null) {
			factory = new Configuration().configure("/com/todo/helper/hibernate.cfg.xml").addAnnotatedClass(Todo.class).addAnnotatedClass(User.class).buildSessionFactory();
		}
		return factory;
	}
	
	public void closeFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}
}
