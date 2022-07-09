package com.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	
	static Connection conn = DBConn.createConn();

	public static int insertstudentdata(Student s) throws SQLException {
		String q = "insert into student(sid,sname,sphone,scity) values(?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setInt(1,s.getSid());
        pstmt.setString(2,s.getSname());
        pstmt.setString(3,s.getSphone());
        pstmt.setString(4,s.getScity());
        int i = pstmt.executeUpdate();
        return i;
	}

	public static ResultSet fetchonestudentinfo(Student s) throws SQLException {
		Statement stmt=conn.createStatement(); 
		String q = "select * from student where sid="+s.getSid();
		ResultSet set = stmt.executeQuery(q);
		return set;
	}

	public static ResultSet fetchallstudentinfo(Student s) throws SQLException {
		Statement stmt=conn.createStatement(); 
		String q = "select * from student ";
		ResultSet set = stmt.executeQuery(q);
		return set;
	}

	public static int deleteonestudentinfo(Student s) throws SQLException {
		String q = "delete from student where sid = ? ";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setInt(1, s.getSid());
        int i = pstmt.executeUpdate();
		return i;
	}

	public static int deleteallstudentinfo(Student s) throws SQLException {
    	Statement stmt=conn.createStatement();
        String q = "delete from student";
        int i = stmt.executeUpdate(q);
		return i;
	}

	public static int updatestudentinfo(Student s) throws SQLException {
		String q = "update student set sname=?,scity=?,sphone=? where sid = ? ";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setString(1, s.getSname());
        pstmt.setString(2, s.getScity());
        pstmt.setString(3, s.getSphone());
        pstmt.setInt(4, s.getSid());
        int i = pstmt.executeUpdate();
		return i;
	}
	

	public static int storeimgofstudnet(Student s) throws SQLException, IOException {
		PreparedStatement ps=conn.prepareStatement("update student set simage=? where sid=?");  
        ps.setInt(2, s.getSid());
        FileInputStream fin=new FileInputStream(s.getSimage());  
        ps.setBinaryStream(1, fin, fin.available()); 
        int i = ps.executeUpdate(); 
        return i;
	}

	public static int storetextfileofstudnet(Student s) throws SQLException, IOException {
		PreparedStatement ps=conn.prepareStatement("update student set sfile=? where sid=?");  
        ps.setInt(2, s.getSid());
        FileReader reader = new FileReader(s.getSfile());
        ps.setCharacterStream(1, reader); 
        int i = ps.executeUpdate(); 
		return i;
	}

	
	public static ResultSet fetchfilestudent(Student s) throws SQLException, IOException {
		PreparedStatement ps=conn.prepareStatement("select * from student where sid=?"); 
		ps.setInt(1, s.getSid());
		ResultSet rs=ps.executeQuery();  
		rs.next();
		return rs;
	}

	public static ResultSet fetchimgstudent(Student s) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from student where sid=?"); 
		ps.setInt(1, s.getSid());
		ResultSet rs=ps.executeQuery();  
		rs.next();
		return rs;
	}
}
