package com.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Task - columns (data,result)  -> ex.( 123 , 321 ), ( Ajay, yajA );
		// create table in your database - 
	    // create database => create database jdbc; -> use jdbc;
	    // create table => create table task2(data varchar(255), result varchar(255));
		
		//1. Load and register the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		//2. Establish connection between application and database
		String user = "root";
		String password = "Lufa@7917";
		String url = "jdbc:mysql://localhost:3306/jdbc";
	    Connection con = DriverManager.getConnection(url, user, password); 
	    
	    //3. Creation of statement object
	    Statement stmt=con.createStatement();
	    
	    System.out.println("Enter your choice 1. Number 2.String");
	    Scanner sc = new Scanner(System.in);
	    int ch = sc.nextInt();
	    System.out.println("Enter your data : ");
	    String str = sc.next();
	    ReverseTask(str,ch,con);
		System.out.println("Data inseted successfully");
		
		//6. close connection
		con.close();
	}

	private static void ReverseTask(String data, int ch, Connection con) throws SQLException {
		Statement stmt=con.createStatement();
		if(ch==1) {
			int n = Integer.parseInt(data);
			String result1 = String.valueOf(numberReverse(n));
			//4. Send and execute sql query
			String w = "insert into task2 values ('" + data + "'" + "," +"'"+result1 +"')"; 
			stmt.executeUpdate(w);
		}
		else if(ch==2) {
			String result2 = stringReverse(data);
			String w = "insert into task2 values ('" + data + "'" + "," +"'"+result2 +"')"; 
			stmt.executeUpdate(w);
		}
	}

	private static String stringReverse(String data) {
		StringBuffer s = new StringBuffer(data);
		String res = s.reverse().toString();
		return res;
	}

	private static int numberReverse(int n) {
		int reverse=0;
		while(n != 0)   
		{  
		int remainder = n % 10;  
		reverse = reverse * 10 + remainder;  
		n = n/10;  
		} 
		return reverse;
	}
}
