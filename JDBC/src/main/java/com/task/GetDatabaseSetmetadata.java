package com.task;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDatabaseSetmetadata {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//1. Load and register the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		//2. Establish connection between application and database
		String user = "root";
		String password = "Lufa@7917";
		String url = "jdbc:mysql://localhost:3306/jdbc";
	    Connection con = DriverManager.getConnection(url, user, password); 
	    
	    DatabaseMetaData dbmd=con.getMetaData();   
		System.out.println("Driver Name: "+dbmd.getDriverName());  
		System.out.println("Driver Version: "+dbmd.getDriverVersion());  
		System.out.println("UserName: "+dbmd.getUserName());  
		System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
		System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
		
	}
}
