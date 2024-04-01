package com.Dao;
import java.sql.*;
import java.util.Scanner;
import com.bean.*;
import com.Connection.*;
public class DeliveryManLogin {
	 private Connection connection;
	   

	    public DeliveryManLogin() {
	    	connection = databaseconnection.createDBconn();
	    }

	    public boolean authenticateDeliveryMan(String deliveryManId, String password) {
	        String sql = "SELECT * FROM dman WHERE login_id = ? AND password = ?";
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, deliveryManId);
	            preparedStatement.setString(2, password);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            return resultSet.next();
	        } catch (SQLException e) {
	             e.printStackTrace();
	            return false;  
	        }
	    }

}

