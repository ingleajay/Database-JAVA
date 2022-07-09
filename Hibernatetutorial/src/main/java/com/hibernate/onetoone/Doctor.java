package com.hibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Doctor {

	@Id
	int did;
	
	@Column(name="Name")
	String dname;
	
	@Column(name="Hname")
	String hospitalname;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="pid", nullable=false)
	Patient patient;

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

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor(int did, String dname, String hospitalname, Patient patient) {
		super();
		this.did = did;
		this.dname = dname;
		this.hospitalname = hospitalname;
		this.patient = patient;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", hospitalname=" + hospitalname + ", patient=" + patient
				+ "]";
	}

}
