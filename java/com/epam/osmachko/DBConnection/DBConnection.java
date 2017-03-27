package com.epam.osmachko.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	public final static String DB_URL = "jdbc:mysql://localhost:3306/UserDB";
	
	public final static String DB_USERNAME = "admin";
	
	public final static String DB_PASSWORD = "admin";
	
	public static Connection getConnection() {
		
			Connection con = null;
			try {
				Class.forName(DB_DRIVER_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("DB Connection created successfuly");
			return con;
			
	}

}
