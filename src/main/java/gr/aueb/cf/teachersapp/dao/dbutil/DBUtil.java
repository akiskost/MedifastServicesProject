package gr.aueb.cf.teachersapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	
	/**
	 * No instances will be available
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException {
		try {
			Class.forName("com.mongodb.jdbc.MongoDriver");
		
			String url = "jdbc:mongodb+srv://akiskost.xw2wo3c.mongodb.net/finalproj";
			String username = "akis";
			String password = "KvWem3SJtjG3HJmk";
			String database = "finalproj";
 			conn = DriverManager.getConnection(url, username, password, database);

//			java.util.Properties p = new java.util.Properties();
//			p.setProperty("user", "akis");
//			p.setProperty("password", "KvWem3SJtjG3HJmk");
//			p.setProperty("database", "finalproj");
//			System.out.println("Connecting to database...");
//			Connection conn = DriverManager.getConnection("jdbc:mongodb+srv://akiskost.xw2wo3c.mongodb.net/?keepAlive=true&poolSize=30&autoReconnect=true&socketTimeoutMS=360000&connectTimeoutMS=360000", p);
// 			Connection conn = DriverManager.getConnection("jdbc:mongodb//akis:X3RLbnYWCUXE8qyA@akiskost.xw2wo3c.mongodb.net/?retryWrites=true&w=majority");


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

