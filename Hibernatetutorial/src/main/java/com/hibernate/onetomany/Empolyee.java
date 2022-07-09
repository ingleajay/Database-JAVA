package com.hibernate.onetomany;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="emp")
public class Empolyee {

	@Id
	int eid;
	String ename;
	int esal;
	
	@OneToMany(mappedBy = "empolyee" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Department> department;

	
	public Empolyee(int eid, String ename, int esal, List<Department> department) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.department = department;
	}


	public Empolyee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public int getEsal() {
		return esal;
	}


	public void setEsal(int esal) {
		this.esal = esal;
	}


	public List<Department> getDepartment() {
		return department;
	}


	public void setDepartment(List<Department> department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Empolyee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", department=" + department + "]";
	}

	
	
}
