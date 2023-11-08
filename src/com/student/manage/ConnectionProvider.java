package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection connection;
	
	public static Connection createConnection() {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			String user = "root";
			String password = "12345";
			String url = "jdbc:mysql://localhost:3306/students_manage";
			
			connection = DriverManager.getConnection(url, user, password);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return connection;
	}
}
