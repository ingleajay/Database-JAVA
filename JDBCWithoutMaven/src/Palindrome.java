
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Task - columns ( data, status )  -> ex.( 121 , true ), ( 123, false )
		// create table in your database - 
		// create database => create database jdbc; -> use jdbc;
		// create table => create table task1(data varchar(255), status varchar(255));
		
		//1. Load and register the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Establish connection between application and database
		String user = "root";
        String password = "Lufa@7917";
        String url = "jdbc:mysql://localhost:3306/jdbc";
        Connection con = DriverManager.getConnection(url, user, password); 
        
        //3. Send and execute sql query + Creation of Prepared statement object
        String q = "insert into task1 values(?,?)";
        PreparedStatement pstmt=con.prepareStatement(q); 
        
        //4. Process result from result set + Business Logic 
        // Dao layer
        HashMap<String, Boolean> f = PalindromeTask();
        for (Entry<String, Boolean> e : f.entrySet()) {
        	pstmt.setString(1,e.getKey());
        	pstmt.setBoolean(2, e.getValue());
        	pstmt.executeUpdate();  
        	System.out.println("Data value and status inserted successfully");
        }
        
        //5. close connection
        con.close();
	}

	// business layer
	private static HashMap<String, Boolean> PalindromeTask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Number 2.String");
		HashMap<String, Boolean> collect = new HashMap<String,Boolean>();
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("Enter your number");
				int n = sc.nextInt();
				boolean result1 = checkPalindromeNumber(n); 
				collect.put(String.valueOf(n),result1);
			}
			else if(ch==2){
				System.out.println("Enter your String");
				String str = sc.next();
				boolean result2 = checkPalindromString(str);
				collect.put(str,result2);
			}
			return collect;
	}
	
	private static boolean checkPalindromeNumber(int n) {
		    int r,sum=0;
			int temp = n;
			 while(n>0){    
				   r=n%10;  
				   sum=(sum*10)+r;    
				   n=n/10;    
			}
			 if(temp==sum)    
				   return true;    
		    else    
				   return false;   
	}

	private static boolean checkPalindromString(String str) {
		StringBuffer s = new StringBuffer(str);
		s.reverse();
		if(str.equalsIgnoreCase(s.toString()))
			return true;
		else
			return false;
	}
}
