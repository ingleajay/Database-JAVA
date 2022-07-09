package com.hibernate.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

	String cname;
	int cprice;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public Certificate(String cname, int cprice) {
		super();
		this.cname = cname;
		this.cprice = cprice;
	}
	
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Certificate [cname=" + cname + ", cprice=" + cprice + "]";
	}
}
