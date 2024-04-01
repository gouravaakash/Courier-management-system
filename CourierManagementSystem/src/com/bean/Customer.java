package com.bean;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String mobileNumber;
	public Customer(int id, String name, String address, String mobileNumber, int packageId, String packageStatus) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.packageId = packageId;
		this.packageStatus = packageStatus;
	}
	
	private static int lastAssignedPackageId=0;
	private int packageId;
    private String packageStatus; // New field
    private int deliveryManId;
	public Customer(int id, String name, String address, String mobileNumber, int packageId, String packageStatus,
			int deliveryManId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.packageId = generateNextPackageId();
	    this.packageStatus = (packageStatus == null || packageStatus.isEmpty()) ? "pending" : packageStatus;
		this.deliveryManId = deliveryManId;
	}
	public int getId() {
		return id;
	}
	private static int generateNextPackageId() {
        return ++lastAssignedPackageId;
    }
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Customer(int id, String name, String address, String mobileNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(String packageStatus) {
		this.packageStatus = (packageStatus == null || packageStatus.isEmpty()) ? "pending" : packageStatus;;
	}
	public int getDeliveryManId() {
		return deliveryManId;
	}
	public void setDeliveryManId(int deliveryManId) {
		this.deliveryManId = deliveryManId;
	}
	

	

}
