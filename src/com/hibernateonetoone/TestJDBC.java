package com.hibernateonetoone;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		//JDBC url and vivek is the database name
		String url = "jdbc:mysql://localhost:3306/hibernateonetoone?useSSL=false";
		
		//username
		String user="root";
		
		//Database password
		String pass="!1@Aezakmi";
		
		try {
			System.out.println("Creating Connection....");
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			
			System.out.println("Connection created Successfully");
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
