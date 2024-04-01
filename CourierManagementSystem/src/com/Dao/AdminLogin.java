package com.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Connection.*;

import com.Dao.CustomerDao;

public class AdminLogin {
	 Connection conn;

    public AdminLogin() {
        // Assign the database connection to the class field
        conn = databaseconnection.createDBconn();
    }

    public boolean authenticateAdmin(String userid, String password) {
        String sql = "SELECT * FROM admin WHERE userid = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userid);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ResultSet getCustomerData() {
        String sql = "SELECT * FROM customers";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void displayCustomerData() {
        ResultSet customerData = getCustomerData();
        if (customerData != null) {
            try {
                System.out.println("Customer Data:");
                while (customerData.next()) {
                    int id = customerData.getInt("id");
                    String name = customerData.getString("name");
                    String address = customerData.getString("address");
                    String mobileNumber = customerData.getString("mobile_number");
                    String packageid = customerData.getString("package_id");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("Mobile Number: " + mobileNumber);
                    System.out.println("Package ID: "+packageid);
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to fetch sender data.");
        }
    }
    
    public void assignDeliveryMan(int customerID, int deliveryManId) {
        CustomerDao customerDao = new CustomerDao(); // Create an instance of CustomerDao
        customerDao.assignDeliveryMan(customerID, deliveryManId);
    }


}
