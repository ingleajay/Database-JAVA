package com.todo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.loggeduser.User;
import com.todo.helper.FactoryProvider;

public class ServicesImpl implements Services{
	
	public boolean savetask(Todo t) {
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		s.save(t);
		tx.commit();
		s.close();
		return true;
	}

	public boolean deletetask(int id) {
		Session s = FactoryProvider.getFactory().openSession();
		Todo t = s.get(Todo.class, id);
		Transaction tx = s.beginTransaction();
		s.delete(t);
		tx.commit();
		s.close();
		return true;
	}

	public boolean updatetask(int id,Todo t) {
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		String query4 = "update Todo set taskDate=:td, taskName=:tn where tid=:id and user_id=:uid";
        Query q4 = s.createQuery(query4);
        q4.setParameter("td",t.getTaskDate());
        q4.setParameter("tn",t.getTname());
        q4.setParameter("id",t.getTid());
        q4.setParameter("uid",t.getUser().getId());
        q4.executeUpdate();
		tx.commit();
		s.close();
		return true;
	}

	public boolean saveuser(User u) {
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		s.save(u);
		tx.commit();
		s.close();
		return true;
	}

	public String getuser(User u) {
		Session s = FactoryProvider.getFactory().openSession();
		 String query1 = "from User as a where a.id=:uid ";
	     Query q1 = s.createQuery(query1);
	     q1.setParameter("uid", u.getId());
	     List<User> a1 = q1.list();
	     String id = null;
	     for(User i : a1) {
	        	id = i.getId();   
	     }
	     if(id==null) {
         	id = "undone";
         }
		return id;
	}

}
