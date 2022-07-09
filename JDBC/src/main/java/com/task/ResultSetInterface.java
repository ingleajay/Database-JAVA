package com.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetInterface {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1. Load and register the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		//2. Establish connection between application and database
		String user = "root";
		String password = "Lufa@7917";
		String url = "jdbc:mysql://localhost:3306/jdbc";
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 3. sql query
		Statement st = con.createStatement();
		String q = "select * from task1";
		ResultSet rs = st.executeQuery(q);
		
		// next() method
		while(rs.next()) {
		System.out.println(rs.getString(1) + "->" + rs.getString(2));
		}
		
		// first() method
//		rs.absolute(1);
//		System.out.println("First row : ");
		
	}
}
