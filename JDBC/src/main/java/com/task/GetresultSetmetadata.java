package com.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GetresultSetmetadata {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//1. Load and register the driver class
	   Class.forName("com.mysql.cj.jdbc.Driver");
				
	   //2. Establish connection between application and database
	   String user = "root";
	   String password = "Lufa@7917";
	   String url = "jdbc:mysql://localhost:3306/jdbc";
	   Connection con = DriverManager.getConnection(url, user, password); 
	   
		Statement stmt=con.createStatement(); 
		String q = "select * from task1";
		ResultSet set = stmt.executeQuery(q);
		ResultSetMetaData rsmd=set.getMetaData();  
		
		System.out.println("Total columns: "+rsmd.getColumnCount());  
		for(int i=1; i<=rsmd.getColumnCount();i++ ) {
			System.out.println("Column Name of " + i + " column: "+ rsmd.getColumnName(i));  
			System.out.println("Column Type of " + i + " column: "+rsmd.getColumnTypeName(i)); 
		}

	}

}
