package com.shopping.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException {
		
		if(connection != null) {
			
			return connection;
		}
		else
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/shoppingdb?useSSL=false";
			String user = "root";
			String password = "cherry";
			
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return connection;
			
		}
	}

}
