package com.hibernate.alldatasave;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="road_address")
public class Address {

	// to tell which road is damage 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	@Column(name="Street" , length = 50)
	private String street;
	
	@Column(name="City" , length = 50)
	private String city;

	private boolean iscorrect;
	private double rate;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Lob
	private byte[] image;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isIscorrect() {
		return iscorrect;
	}
	public void setIscorrect(boolean iscorrect) {
		this.iscorrect = iscorrect;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Address(int aid, String street, String city, boolean iscorrect, double rate, Date date, byte[] image) {
		super();
		this.aid = aid;
		this.street = street;
		this.city = city;
		this.iscorrect = iscorrect;
		this.rate = rate;
		this.date = date;
		this.image = image;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", city=" + city + ", iscorrect=" + iscorrect + ", rate="
				+ rate + ", date=" + date + ", image=" + Arrays.toString(image) + "]";
	}
}
