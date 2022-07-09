package com.hibernateproject.byxml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="laptop")
public class Computer {

	@Id
	@Column(name="lid")
	int cid;
	
	@Transient
	@Column(name="lbrand")
	String cbrand;
	
	@Column(name="lprice")
	int cprice;
	public Computer(int cid, String cbrand, int cprice) {
		super();
		this.cid = cid;
		this.cbrand = cbrand;
		this.cprice = cprice;
	}
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCbrand() {
		return cbrand;
	}
	public void setCbrand(String cbrand) {
		this.cbrand = cbrand;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	@Override
	public String toString() {
		return "Computer [cid=" + cid + ", cbrand=" + cbrand + ", cprice=" + cprice + "]";
	}
}
