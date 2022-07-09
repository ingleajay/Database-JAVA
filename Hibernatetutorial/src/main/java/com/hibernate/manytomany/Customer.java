package com.hibernate.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	int cid;
	String cname;
	
	@ManyToMany(mappedBy = "customers")
	List<Product> products;

	public Customer(int cid, String cname, List<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.products = products;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", products=" + products + "]";
	}
}
