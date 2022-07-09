package com.hibernate.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {

	@Id
	int pid;
	
	@Column(name="pName")
	String pname;
	
	@Column(name="Disease")
	String pdisease;
	
	// mapped by - means konsa attrubutes ye patient table mai na ho - doctor id 
	@OneToOne(mappedBy = "patient")
	Doctor doctor;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdisease() {
		return pdisease;
	}

	public void setPdisease(String pdisease) {
		this.pdisease = pdisease;
	}
	
	

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	

	public Patient(int pid, String pname, String pdisease, Doctor doctor) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdisease = pdisease;
		this.doctor = doctor;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", pdisease=" + pdisease + ", doctor=" + doctor + "]";
	}

	
	
}
