package com.Connection;
import java.sql.*;

public class databaseconnection {
	
	private static Connection conn ;
	public static Connection createDBconn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/creditmanagementsystem";
			String user = "root";
            String password = "Leomessi@10";
            conn = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
            e.printStackTrace();
		}
		return conn;
	}
	
	

}
