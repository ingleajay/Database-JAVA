package com.todo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.loggeduser.User;

@Entity
@Table(name="Task")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tid;
	
	@Column(name="TaskName" , length = 50)
	String tname;
	
	@Temporal(TemporalType.DATE)
	private Date TaskDate;
	
	@ManyToOne
	User user;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Date getTaskDate() {
		return TaskDate;
	}

	public void setTaskDate(Date taskDate) {
		TaskDate = taskDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Todo(int tid, String tname, Date taskDate, User user) {
		super();
		this.tid = tid;
		this.tname = tname;
		TaskDate = taskDate;
		this.user = user;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Todo [tid=" + tid + ", tname=" + tname + ", TaskDate=" + TaskDate + ", user=" + user + "]";
	}

	
}
