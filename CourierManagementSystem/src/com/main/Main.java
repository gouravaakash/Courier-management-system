package com.main;

import java.util.List;
import java.util.Scanner;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Connection.*;
import com.Dao.*;
import com.bean.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		CustomerDao customerDao = new CustomerDao();
		AdminLogin admin = new AdminLogin();
		boolean isAdminLoggedIn = false;
		Customer customer = new Customer();

		DeliveryManLogin deliveryManLogin = new DeliveryManLogin();

		while (true) {
			System.out.println("<<****************************************>>");
			System.out.println("<<                                        >>");
			System.out.println("<<***Welcome To courier Delivery System***>>");
			System.out.println("<<                                        >>");
			System.out.println("<<****************************************>>");
			System.out.println("<<________________________________________>>");
			System.out.println("<<                                        >>");
			System.out.println("<<          1.Admin Login                 >>");
			System.out.println("<<          2.User options                >>");
			System.out.println("<<          3.Delivery Man Login          >>");
			System.out.println("<<          4.Exit.....                   >>");
			System.out.println("<<________________________________________>>");
			System.out.println("<<****************************************>>");
			System.out.println("<<            Enter your choice:          >>");
			System.out.println("<<****************************************>>");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// Admin login
				System.out.print("Enter User ID: ");
				String userid = scanner.next();
				System.out.print("Enter password: ");
				String password = scanner.next();
				if (admin.authenticateAdmin(userid, password)) {
					System.out.println("Login successful.");

					// Admin menu
					while (true) {

						System.out.println("<<****************************************>>");
						System.out.println("<<                                        >>");
						System.out.println("<<***************Admin Menu:**************>>");
						System.out.println("<<________________________________________>>");
						System.out.println("<<                                        >>");
						System.out.println("<<          1. Delivery Management        >>");
						System.out.println("<<          2. Staff management           >>");
						System.out.println("<<          3. Logout                     >>");
						System.out.println("<<                                        >>");
						System.out.println("<<________________________________________>>");
						System.out.println("<<****************************************>>");
						System.out.println("<<            Enter your choice:          >>");
						System.out.println("<<****************************************>>");

						int adminchoice = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character
						switch (adminchoice) {
//                            deliverymanagement
						case 1:

							while (true) {
								System.out.println("<<****************************************>>");
								System.out.println("<<                                        >>");
								System.out.println("<<**********Delivery Management:**********>>");
								System.out.println("<<________________________________________>>");
								System.out.println("<<                                        >>");
								System.out.println("<<    1. Assign Delivery Man              >>");
								System.out.println("<<    2. Display customer data with status>>");
								System.out.println("<<    3. Delete Customer Data             >>");
								System.out.println("<<    4. Back to Admin Menu               >>");
								System.out.println("<<________________________________________>>");
								System.out.println("<<****************************************>>");
								System.out.println("<<          Enter your choice:            >>");
								System.out.println("<<****************************************>>");
								
								int deliverymangchoice = scanner.nextInt();
								scanner.nextLine();

								if (deliverymangchoice == 1) {
									// Code for assigning delivery man
									System.out.print("Enter Customer ID to assign a delivery man: ");
									int customerIdToAssign = scanner.nextInt();
									System.out.print("Enter Delivery Man ID: ");
									int deliveryManIdToAssign = scanner.nextInt();
									admin.assignDeliveryMan(customerIdToAssign, deliveryManIdToAssign);
								} else if (deliverymangchoice == 2) {
									// Display customer data with status
									// Display sent data with delivery statuses
									List<Customer> sentDataWithStatus = customerDao.getSentDataWithStatus();
									System.out.println("Sent Data with Delivery Status:");
									for (Customer sent : sentDataWithStatus) {
										System.out.println("Customer ID: " + sent.getId());
										System.out.println("Name: " + sent.getName());
										System.out.println("Address: " + sent.getAddress());
										System.out.println("Mobile Number: " + sent.getMobileNumber());
										System.out.println("Package ID: " + sent.getPackageId());
										System.out.println("Package Status: " + sent.getPackageStatus());
										System.out.println();
									}
								} else if (deliverymangchoice == 3) {
									// Delete Data

									System.out.print("Enter customer ID to delete: ");
									int customerIDtoDelete = scanner.nextInt();
									customerDao.deleteSender(customerIDtoDelete);
									// System.out.println("Sender data deleted successfully.");
								} else if (deliverymangchoice == 4) {
									// Logout admin
//									System.out.println("innerloopbreak");
									break;
								}

								else {
									System.out.println("invalid choice");
								}
								break;
							} 
//								System.out.println("outerloop break");
								
							break;
								
								
							
//						System.out.println("outermost");
						
					

						case 2:
//                            	manage staff
							if(adminchoice ==2) {
							while (true) {
								System.out.println(" ╔══════════════════════════════════════════╗");
								System.out.println("║         ---- MANAGE STAFF MENU ----        ║");
								System.out.println(" ╚══════════════════════════════════════════╝");
								System.out.println("||**********************************************||");
								System.out.println("1. Add Staff");
								System.out.println("2. Staff List");
								System.out.println("3. Delete Staff");
								System.out.println("4. Back to Main Menu");
								System.out.println("||**********************************************||");
								System.out.print("Enter your choice: ");
								int Managestaffchoice = Integer.parseInt(scanner.nextLine());

								switch (Managestaffchoice) {
								case 1:
									managestaff.addStaff(scanner);
									break;
								case 2:
									managestaff.staffList();
									break;
								case 3:
									managestaff.deleteStaff(scanner);
									break;
								case 4:
									break; // Return to the main menu
								default:
									System.out.println("Invalid choice! Please try again.");
								}
								if (Managestaffchoice == 4) {
									break; // Exit the inner while loop to return to the outer while loop
								}
							}
							break;
							}
						
						case 3:
							if(adminchoice == 3) {
							System.out.println("logged out sucessfully");
							break;
							}
							
							
						}
						
						

					}
					
				

				} else {

					System.out.println("Login failed. Invalid credentials.");
					break;
				}
				
				
			case 2:
				if(choice == 2) {
				while (true) {
					System.out.println("<<________________________________________>>");
					System.out.println("<<                                        >>");
					System.out.println("<<    1. Add new courier                  >>");
					System.out.println("<<    2. Track courier                    >>");
					System.out.println("<<    3. Back to Main menu                >>");
					System.out.println("<<                                        >>");
					System.out.println("<<________________________________________>>");

					int userchoice = scanner.nextInt();

					if (userchoice == 1) {
						System.out.print("Enter Sender ID: ");
						int id = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Enter Sender Name: ");
						String name = scanner.nextLine();
						System.out.print("Enter Sender Address: ");
						String address = scanner.nextLine();
						System.out.print("Enter Sender Mobile Number: ");
						String mobileNumber = scanner.nextLine();

						// Set sender data using setter methods
						customer.setId(id);
						customer.setName(name);
						customer.setAddress(address);
						customer.setMobileNumber(mobileNumber);

						customerDao.AddCustomer(customer);
						System.out.println("Sender data added successfully.");
						break;
					} else if (userchoice == 2) {
					    System.out.println("Enter package ID to track your package:");
					    int packageID = scanner.nextInt();
					    Customer trackedCustomer = customerDao.trackCourier(packageID);

					    if (trackedCustomer != null) {
					        // Display the details of the tracked customer
					        System.out.println("Customer Details:");
					        System.out.println("ID: " + trackedCustomer.getId());
					        System.out.println("Name: " + trackedCustomer.getName());
					        System.out.println("Address: " + trackedCustomer.getAddress());
					        System.out.println("Mobile Number: " + trackedCustomer.getMobileNumber());
					        System.out.println("Package ID: " + trackedCustomer.getPackageId());
					        System.out.println("Package Status: " + trackedCustomer.getPackageStatus());
					        System.out.println("Delivery Man ID: " + trackedCustomer.getDeliveryManId());
					    } else {
					        System.out.println("No customer found with the provided package ID.");
					    }
					}else if(userchoice==3) {
						break;
					}
					
				}
				}
				break;
			case 3:
				// Delivery man login
				System.out.println("Enter Delivery Man ID: ");
				String deliveryManid = scanner.next();
				System.out.println("Enter password: ");
				String deliveryManPassword = scanner.next();
				if (deliveryManLogin.authenticateDeliveryMan(deliveryManid, deliveryManPassword)) {
					System.out.println("Delivery Man Login Successful.");

					// Admin menu
					while (true) {
						System.out.println("<<****************************************>>");
						System.out.println("<<                                        >>");
						System.out.println("<<***********Delivery Man Menu:***********>>");
						System.out.println("<<________________________________________>>");
						System.out.println("<<                                        >>");
						System.out.println("<<      1. Show available customer data   >>");
						System.out.println("<<        2. Update delivery              >>");
						System.out.println("<<           3. Logout                    >>");
						System.out.println("<<            4. exit                     >>");
						System.out.println("<<________________________________________>>");
						System.out.println("<<****************************************>>");
						System.out.println("<<            Enter your choice:          >>");
						System.out.println("<<****************************************>>");
						int Choice = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character
						if (Choice == 1) {
							// Code for Display data
							admin.displayCustomerData();
						} else if (Choice == 2) {
							// send with package id
							System.out.print("Enter package Id: ");
							int packageId = scanner.nextInt();
							System.out.print("Enter Sender Id: ");
							int customerID = scanner.nextInt();
							scanner.nextLine();

							// Update the package ID and status in the database
							customerDao.sendWithPackageId(packageId, "Delivered", customerID);

						}

						else if (Choice == 3) {
							// Logout admin
							break;
						} else {
							System.out.println("Invalid choice. Please try again.");
						}
					}
				} else {
					System.out.println("Login failed. Invalid credentials.");
				}
				
			
		
			case 4:
                // Exit the program
            	boolean consoleExit = true; // Set the exit flag to true
                System.out.println("Exiting Console From Package Delivery System. Jai Shree Ram !!!!");
                System.exit(0); 
                break;
           
            
           

            default:
                System.out.println("Invalid choice. Please try again.");
       		    }	
			}

		}

	}

