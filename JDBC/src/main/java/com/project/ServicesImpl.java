package com.project;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ServicesImpl implements Services{
	
	Scanner sc = new Scanner(System.in);
	Student s = new Student();
	public void getoneStudent() throws SQLException {
		System.out.println("Get Student Data by Id");
		System.out.println("Enter Student Id : ");
		int sid = sc.nextInt();
		s.setSid(sid);
		ResultSet set = StudentDao.fetchonestudentinfo(s);
		while (set.next()) {
            int id = set.getInt(1);
            String name = set.getString("sname");
            String phone = set.getString("sphone");
            String city = set.getString("scity");
            System.out.println("Students Details by statement : ");
            System.out.println("Id : " + id);
            System.out.println("Name: " + name);
            System.out.println("Phone: " + phone);
            System.out.println("city: " + city);
            System.out.println("+++++++++++++++++++++++++++++++");
        }
	}

	public void getallStudent() throws SQLException {
		System.out.println("Get All Student Data");
		ResultSet set = StudentDao.fetchallstudentinfo(s);
		while (set.next()) {
            int id = set.getInt(1);
            String name = set.getString("sname");
            String phone = set.getString("sphone");
            String city = set.getString("scity");
            System.out.println("Students Details by statement : ");
            System.out.println("Id : " + id);
            System.out.println("Name: " + name);
            System.out.println("Phone: " + phone);
            System.out.println("city: " + city);
            System.out.println("+++++++++++++++++++++++++++++++");
        }
	}

	public void updatestoreStudent() throws SQLException {
		System.out.println("Update student Data");
		s = getinput();
		int i = StudentDao.updatestudentinfo(s);
		if(i != 0)
			System.out.println("Student Data is updated successfully");
	}

	public void deleteallStudent() throws SQLException {
		int i = StudentDao.deleteallstudentinfo(s);
		if(i != 0)
			System.out.println(" All data deleted successfully.");
	}

	public void deleteoneStudent() throws SQLException {
		System.out.println("Delte Student Data by Id");
		System.out.println("Enter Student Id : ");
		int sid = sc.nextInt();
		s.setSid(sid);
		int i = StudentDao.deleteonestudentinfo(s);
		if(i != 0)
			System.out.println(sid + " is delete successfully.");
	}

	public void storeInfoStudent() throws SQLException {
		System.out.println("Enter student details : ");
		s = getinput();
		int i = StudentDao.insertstudentdata(s);
		if(i != 0)
			System.out.println("Student Data is store successfully");
	}

	private Student getinput() {
		System.out.println("Enter Student Id");
		int studId = sc.nextInt();
		System.out.println("Enter Student Name");
		String studName = sc.next();
		System.out.println("Enter Student Phone");
		String studPhone = sc.next();
		System.out.println("Enter Student City");
		String studCity = sc.next();
		s.setSid(studId);
		s.setSname(studName);
		s.setSphone(studPhone);
		s.setScity(studCity);
		return s;
	}

	public void storeImgStudent() throws SQLException, IOException {
		System.out.println("Store student profile");
		System.out.println("Enter student Id");
		int sid = sc.nextInt();
		String url = "F:\\Java\\JDBC\\src\\main\\java\\com\\project\\img\\";
		System.out.println("Enter profile Image name ");
		String img = sc.next();
		String location =url.concat(img);
		s.setSid(sid);
		s.setSimage(location);
		int i = StudentDao.storeimgofstudnet(s);
		if(i != 0)
			System.out.println("Student profile pic is store successfully");
	}

	public void storefileStudent() throws SQLException, IOException {
		System.out.println("Store student text file");
		System.out.println("Enter student Id");
		int sid = sc.nextInt();
		String url = "F:\\Java\\JDBC\\src\\main\\java\\com\\project\\img\\";
		System.out.println("Enter Text File name ");
		String file = sc.next();
		String location =url.concat(file);
		s.setSid(sid);
		s.setSfile(location);
		int i = StudentDao.storetextfileofstudnet(s);
		if(i != 0)
			System.out.println("Student Text file is store successfully");
	}

	public void getImgStudent() throws SQLException, IOException {
		System.out.println("Get Image in your location");
		System.out.println("Enter student id");
		int sid = sc.nextInt();
		s.setSid(sid);
		System.out.println("Enter your image name : ");
		String url = sc.next();
		s.setSfile(url);
		ResultSet set = StudentDao.fetchimgstudent(s);
	    Blob c=set.getBlob(5); 
	    byte barr[]=c.getBytes(1,(int)c.length());
		FileOutputStream fw=new FileOutputStream("F:\\Java\\JDBC\\src\\main\\java\\com\\project\\img\\fetch\\ "+ url);  
		fw.write(barr); 
		System.out.println("Your file is saved successsfully in location with name " + url);
	}

	public void getFileStudent() throws SQLException, IOException {
		System.out.println("Get your file by Id");
		int sid = sc.nextInt();
		s.setSid(sid);
		System.out.println("Enter your file name : ");
		String url = sc.next();
		s.setSfile(url);
		ResultSet set = StudentDao.fetchfilestudent(s);
		Clob c=set.getClob(6);  
		Reader r=c.getCharacterStream();
		FileWriter fw=new FileWriter("F:\\Java\\JDBC\\src\\main\\java\\com\\project\\img\\fetch\\ "+ url);  
		int i;  
		while((i=r.read())!=-1)  
		  fw.write((char)i);              
		fw.close(); 
		System.out.println("Your file is saved successsfully in location with name " + url);
	}
}
