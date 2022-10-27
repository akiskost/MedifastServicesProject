package com.test.medifastservices.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class DBUtil {
	private static Connection conn;
	
	/**
	 * No instances will be available
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			String url = "jdbc:mysql://localhost:3306/patientsdb?serverTimezone=UTC";
			String username = "admin";
			String password = "admin";
			
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}

//MONGO DB UTIL UNUSED

//public class DBUtil {
//
//	private static Connection conn;
//	private DBUtil() {}
//	private static final String URL = "jdbc:mongodb://cluster0.ktad2.mongodb.net:27017/test?ssl=true&authSource=admin";
//
//	public static Connection openConnection() throws SQLException {
//
//		java.util.Properties p = new java.util.Properties();
//		p.setProperty("user", "akis2");
//		p.setProperty("password", "mEkzUdi3RPtgAM1f");
//		p.setProperty("database", "test");
//		p.setProperty("loglevel", Level.SEVERE.getName());
//
//		//Registers JDBC Driver
//		try {
//			Class.forName("com.mongodb.jdbc.MongoDriver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("ERROR: Unable to load SQLServer JDBC Driver");
//			e.printStackTrace();
//		}
//		System.out.println("MongoDB JDBC Driver has been registered...");
//
//
//		//Connects to mongodb database
//
//		System.out.println("Trying to get a connection to the database...");
//		try {
//			Connection conn = DriverManager.getConnection(URL, p);
//
//		} catch (SQLException  e) {
//			System.out.println("ERROR: Unable to establish a connection with the database!");
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//
//
//
//
//
//
//
//
//
//
//	public static void closeConnection() throws SQLException {
//		conn.close();
//	}
//}
