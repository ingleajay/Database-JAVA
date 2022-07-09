package com.hibernate.byannotation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Computer1 {

	@Id
	int cid;
	String cbrand;
	int cprice;
	public Computer1(int cid, String cbrand, int cprice) {
		super();
		this.cid = cid;
		this.cbrand = cbrand;
		this.cprice = cprice;
	}
	public Computer1() {
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
