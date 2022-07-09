package com.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException, IOException {
		
		// create table student( sid int, sname varchar(255), sphone varchar(255), scity varchar(255), simage longblob, sfile longtext);

		System.out.println("+++++++ Welcome to Student Portfolio Managemnet System +++++++++ ");
		System.out.println("\n1.Get One student \n2.Get All Student "
				+ "\n3.Update student \n4.delete all student"
				+ "\n5.delete one student \n6.store info student \n7.store img of student"
				+ "\n8.store file of student \n9.get img of student \n10.get file of student");
		
		Scanner sc = new Scanner(System.in);
		ServicesImpl si = new ServicesImpl();
		
		while(true) {
			System.out.println("\nEnter your choice ");
			int choice = sc.nextInt();
			switch(choice) {
			 case 1:si.getoneStudent();
				   break;
			 case 2:si.getallStudent();
				 break;
			 case 3:si.updatestoreStudent();
				 break;
			 case 4:si.deleteallStudent();
				 break;
			 case 5:si.deleteoneStudent();
				    break;
			 case 6:si.storeInfoStudent();
				    break;
			 case 7:si.storeImgStudent();
				 break;
			 case 8:si.storefileStudent();
				 break;
			 case 9: si.getImgStudent();
			       break;
			 case 10: si.getFileStudent();
			      break;
			 default:System.out.println("Incorrect option enter");
			}
		}
		
	}
}
