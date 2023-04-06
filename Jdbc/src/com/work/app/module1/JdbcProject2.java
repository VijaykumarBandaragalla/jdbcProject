package com.work.app.module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class JdbcProject2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Savepoint sp = null;
		String query1 = "insert into girmiti.emp values(?,?,?,)";
		String query2 = "insert into girmiti.emp values(?,?,?,)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			con.setAutoCommit(false);
			
			pstmt1 = con.prepareStatement(query1);
			pstmt2 = con.prepareStatement(query2);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("inserting data into emp table");
			System.out.println("enter empno");
			int empno=sc.nextInt();
			pstmt1.setInt(1, empno);
			System.out.println("enter empname");
			String empname=sc.next();
			pstmt1.setString(2, empname);
			System.out.println("enter empsal");
			int empsal=sc.nextInt();
			pstmt1.setInt(3, empsal);
			pstmt1.execute();
			sp = con.setSavepoint();
			System.out.println("emp details updated");

			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
