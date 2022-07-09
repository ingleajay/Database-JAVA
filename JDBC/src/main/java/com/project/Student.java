package com.project;

public class Student {

	 private int sid;
	 private String sname;
	 private String sphone;
	 private String scity;
	 private String simage;
	 private String sfile;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSimage() {
		return simage;
	}
	public void setSimage(String simage) {
		this.simage = simage;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public Student(int sid, String sname, String sphone, String scity, String simage, String sfile) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sphone = sphone;
		this.scity = scity;
		this.simage = simage;
		this.sfile = sfile;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sphone=" + sphone + ", scity=" + scity + ", simage="
				+ simage + ", sfile=" + sfile + "]";
	}
}
