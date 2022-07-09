package com.loggeduser;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.todo.Todo;

@Entity
public class User {

	@Id
	String id;
	
	@Column(name="UserName")
	String uname;
	
	@Column(name="UserEmail")
	String uemail;
	
	@Column(name="UserImg")
	String img;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
    List<Todo> todo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Todo> getTodo() {
		return todo;
	}

	public void setTodo(List<Todo> todo) {
		this.todo = todo;
	}

	public User(String id, String uname, String uemail, String img, List<Todo> todo) {
		super();
		this.id = id;
		this.uname = uname;
		this.uemail = uemail;
		this.img = img;
		this.todo = todo;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", uemail=" + uemail + ", img=" + img + ", todo=" + todo + "]";
	}
	
}
