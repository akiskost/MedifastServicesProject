package com.test.medifastservices.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class DBUtil {
	private static Connection conn;

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
