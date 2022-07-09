package com.hibernate.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	int pid;
	String pname;
	int price;
	
	@ManyToMany
	List<Customer> customers;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Product(int pid, String pname, int price, List<Customer> customers) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.customers = customers;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", customers=" + customers + "]";
	}
}
