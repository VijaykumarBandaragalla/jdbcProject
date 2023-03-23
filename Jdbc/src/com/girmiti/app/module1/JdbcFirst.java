package com.girmiti.app.module1;

import java.sql.*; //1st step of jdbc importing all the packages

public class JdbcFirst {
	public static void main(String[] args) {
//		Connection con = null;
		//2nd step of jdbc..!! load and register the driver
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered..!");
			
			   String mysqlUrl = "jdbc:mysql://localhost:3306/Girmiti";
			   Connection con=DriverManager.getConnection(mysqlUrl, "root", "root");
//			   Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
			   System.out.println("Connection established......");	     
			   //Creating a Prepared Statement      
			   String query = "INSERT INTO testDb(Name, Salary, Location) VALUES (?, ?, ?)";	     
			   PreparedStatement pstmt = con.prepareStatement(query);	    
			   pstmt.setString(1, "vijay");	      
			   pstmt.setInt(2, 67); 
			   pstmt.setString(3, "bang");
			   int num = pstmt.executeUpdate();	 
			   System.out.println("Rows inserted ....");
		
			
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?username=root&password=root");
//			System.out.println("connection established between java and sql");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		
		}
	}
}


