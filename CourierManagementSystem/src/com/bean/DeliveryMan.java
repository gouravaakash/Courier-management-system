package com.bean;

public class DeliveryMan {
	 private int id;
	    public DeliveryMan(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
		private String password;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}

