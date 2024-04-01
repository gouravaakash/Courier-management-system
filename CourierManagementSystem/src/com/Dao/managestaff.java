package com.Dao;
import com.Connection.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class managestaff {
	static Connection conn = databaseconnection.createDBconn();
	
    public static void addStaff(Scanner scanner) {
        try  {
            String sql = "INSERT INTO staff (id, first_name, last_name, email, password, mobile_no, gender, date_of_birth, branch) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = conn.prepareStatement(sql);

            System.out.println(" ╔══════════════════════════════════════════╗");
            System.out.println("║           ---- ADD NEW STAFF ----          ║");
            System.out.println(" ╚══════════════════════════════════════════╝");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            statement.setInt(1, id);

            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            statement.setString(2, firstName);

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            statement.setString(3, lastName);

            System.out.print("Email ID: ");
            String emailId = scanner.nextLine();
            statement.setString(4, emailId);

            System.out.print("Password: ");
            String password = scanner.nextLine();
            statement.setString(5, password);

            System.out.print("Mobile No: ");
            String mobileNo = scanner.nextLine();
            statement.setString(6, mobileNo);

            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            statement.setString(7, gender);

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            statement.setString(8, dob);

            System.out.print("Select Branch: ");
            String branch = scanner.nextLine();
            statement.setString(9, branch);
            System.out.println("==============================================");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
            	System.out.println("|=============================================|");
           	    System.out.println("     -- Staff Details Added Successfully! --  ");
           	    System.out.println("|=============================================|");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display staff list
    public static void staffList() {
        try  {
            String sql = "SELECT id,first_name, last_name, email, mobile_no, branch FROM staff";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println(" ╔══════════════════════════════════════════╗");
            System.out.println("║              -- Staff List --              ║");
            System.out.println(" ╚══════════════════════════════════════════╝");
            while (resultSet.next()) {
            	System.out.println("ID: " + resultSet.getInt("id"));
                String fullName = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
                System.out.println("Name: " + fullName);
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Mobile No: " + resultSet.getString("mobile_no"));
                System.out.println("Branch: " + resultSet.getString("branch"));
                System.out.println("=============================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete staff
    public static void deleteStaff(Scanner scanner) {
        try  {
            System.out.print("Enter the ID of the staff member you want to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            String sql = "DELETE FROM staff WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Staff member with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No staff member found with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
