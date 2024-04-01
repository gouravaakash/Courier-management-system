package com.Dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import com.bean.Customer;
import com.Connection.*;
import exception.PackageDeliveryException;

public class CustomerDao implements CustomerInterface {	
private Connection connection;

	 public CustomerDao() {
		  	connection = databaseconnection.createDBconn();
    }
	@Override
		   public void AddCustomer(Customer customer) {
		        String sql = "INSERT INTO customers (id, name, address, mobile_number) VALUES (?, ?, ?, ?)";
		        try {
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setInt(1, customer.getId());
		            preparedStatement.setString(2, customer.getName());
		            preparedStatement.setString(3, customer.getAddress());
		            preparedStatement.setString(4, customer.getMobileNumber());
		            preparedStatement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		@Override
		    public void updatePackageStatus(int customerId, String status) {
		        String sql = "UPDATE customers SET package_status = ? WHERE id = ?";
		        try {
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setString(1, status);
		            preparedStatement.setInt(2, customerId);
		            preparedStatement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		@Override
		    public List<Customer> getSentDataWithStatus() {
		        List<Customer> customers = new ArrayList<Customer>();
		        String sql = "SELECT * FROM customers";
		        try {
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            ResultSet resultSet = preparedStatement.executeQuery();
		            while (resultSet.next()) {
		                Customer customer = new Customer();
		                customer.setId(resultSet.getInt("id"));
		                customer.setName(resultSet.getString("name"));
		                customer.setAddress(resultSet.getString("address"));
		                customer.setMobileNumber(resultSet.getString("mobile_number"));
		                customer.setPackageId(resultSet.getInt("package_id"));
		                customer.setPackageStatus(resultSet.getString("package_status"));
		                customers.add(customer);
		                
		          
		              
		            }
		        }
		         catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return customers;
		    }
		@Override
		    public void sendWithPackageId(int packageId, String status, int customerId){
		        String sql = "UPDATE customers SET package_id=?, package_status=? WHERE id=?";
		        String checkSql = "SELECT package_status FROM customers WHERE id = ?";
		        try {
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setInt(1, packageId);
		            preparedStatement.setString(2, status);
		            preparedStatement.setInt(3, customerId);
		            preparedStatement.executeUpdate();
		            System.out.println("Package ID and Status updated successfully.");
		            
		            // Check statement
		            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
		            checkStatement.setInt(1, customerId);
		            ResultSet resultSet = checkStatement.executeQuery();

		            if (resultSet.next()) {
		                String currentStatus = resultSet.getString("package_status");
		                
		                // Check if the package has already been delivered
		                if ("Delivered".equals(currentStatus)) {
		                	//throw new PackageDeliveryException("Package has already been delivered and cannot be delivered again.");
		                    System.out.println("Package has already been delivered and cannot be delivered again.");
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		@Override
		public void deleteSender(int Id) {
		    String sql = "DELETE FROM customers WHERE id = ?";
		    try {
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
		        preparedStatement.setInt(1,Id);
		        
		int rowsAffected = preparedStatement.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            System.out.println("Record deleted successfully.");
		        } else {
		            System.out.println("Cannot delete: ID not found in the database.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		 
		    
		@Override
		    public void assignDeliveryMan(int customerID, int deliveryManId) {
		        String sql = "UPDATE customers SET delivery_man_id = ? WHERE id = ?";
		        try {
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setInt(1, deliveryManId);
		            preparedStatement.setInt(2, customerID);
		            preparedStatement.executeUpdate();
		            System.out.println("Delivery man assigned successfully.");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		
		 public Customer trackCourier(int packageId) {
		        String sql = "SELECT * FROM customers WHERE package_id = ?";
		        try {
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setInt(1, packageId);
		            ResultSet resultSet = preparedStatement.executeQuery();
		            
		            // If a record with the package ID is found, create and return a Customer object
		            if (resultSet.next()) {
		                int id = resultSet.getInt("id");
		                String name = resultSet.getString("name");
		                String address = resultSet.getString("address");
		                String mobileNumber = resultSet.getString("mobile_number");
		                String packageStatus = resultSet.getString("package_status");
		                int deliveryManId = resultSet.getInt("delivery_man_id");

		                return new Customer(id, name, address, mobileNumber, packageId, packageStatus, deliveryManId);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        // If no record is found with the given package ID, return null
		        System.out.println("no packageid found");
		        return null;
		    }
		@Override
		public void AddCustomer() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void updatePackageStatus() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void sendWithPackageId() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void assignDeliveryMan() {
			// TODO Auto-generated method stub
			
		}
		
		
	
		

		

		}






