package com.Dao;

import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;
import com.bean.Customer;
import exception.PackageDeliveryException;

public interface CustomerInterface {
	public void AddCustomer();
	public void updatePackageStatus();
	public List<Customer> getSentDataWithStatus();
	public void sendWithPackageId();
	public void assignDeliveryMan();
	void AddCustomer(Customer customer);
	void updatePackageStatus(int customerId, String status);
	void sendWithPackageId(int packageId, String status, int customerId);
	void assignDeliveryMan(int customerId, int deliveryManId);
	public void deleteSender(int customerId);
		
	

}
