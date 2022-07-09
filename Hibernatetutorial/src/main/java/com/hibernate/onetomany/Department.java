package com.hibernate.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Department {

	@Id
	int did;
	String dname;
	
	@ManyToOne
	Empolyee empolyee;


	public Department(int did, String dname, Empolyee empolyee) {
		super();
		this.did = did;
		this.dname = dname;
		this.empolyee = empolyee;
	}


	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public Empolyee getEmpolyee() {
		return empolyee;
	}


	public void setEmpolyee(Empolyee empolyee) {
		this.empolyee = empolyee;
	}


	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", empolyee=" + empolyee + "]";
	}
	
	
}
