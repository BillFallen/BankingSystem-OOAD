package com.banking.dao;

import com.banking.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {

    public void saveCustomer(Customer customer) {
        String sql = "INSERT INTO customers (customer_id, first_name, surname, address, contact_info) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Note: We need a getCustomerId() method in the Customer class!
            pstmt.setString(1, customer.getCustomerId());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getSurname());
            pstmt.setString(4, customer.getAddress());
            pstmt.setString(5, customer.getContactInfo());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Customer saved to database successfully!");
            }

        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }
}