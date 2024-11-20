package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatement {

	//Insert Data
	public void insertDemo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		PreparedStatement ps = c.prepareStatement("insert into sales (SalesId, product, Amount) values (?,?,?)");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the sales Id: ");
		int id = sc.nextInt();

		System.out.println("Enter the Product: ");
		String p = sc.next();

		System.out.println("Enter the Amount: ");
		int amount = sc.nextInt();

		ps.setInt(1, id);
		ps.setString(2, p);
		ps.setInt(3, amount);

		ps.executeUpdate();
		System.out.println("Data is Inserted Succesfully....");

	}

	//Update Data
	public void updataDemo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		PreparedStatement ps = c.prepareStatement("update sales set product =?  where SalesId =?");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Product: ");
		String p = sc.next();

		System.out.println("Enter the sales Id: ");
		int id = sc.nextInt();

		ps.setString(1, p);
		ps.setInt(2, id);

		ps.executeUpdate();
		System.out.println("Data is Updated Succesfully....");

	}

	//Delete Data
	public void deleteDemo() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		PreparedStatement ps = c.prepareStatement("delete from sales where SalesId =?");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Sales Id: ");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ps.executeUpdate();

		System.out.println("Data is Deleted Succesfully....");

	}

	//Fetch Data
	public void fetchData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		PreparedStatement ps = c.prepareStatement("select * from sales");
		ResultSet rs = ps.executeQuery();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID: ");
		int id = sc.nextInt();

		while (rs.next()) {

			System.out.println("Sales Id: " + rs.getInt("SalesId"));
			System.out.println("Product Name: " + rs.getString("product"));
			System.out.println("Amount: " + rs.getInt("Amount"));
		}
	}
}
