package com.banking.controller;

import com.banking.dao.CustomerDAO;
import com.banking.model.Customer;
import com.banking.view.AccountView;
import com.banking.view.LoginView;
import javafx.stage.Stage;

public class LoginController {
    private LoginView loginView;
    private Stage stage;

    public LoginController(LoginView loginView, Stage stage) {
        this.loginView = loginView;
        this.stage = stage;
        setupListeners();
    }

    private void setupListeners() {
        // Tell the button what to do when clicked
        loginView.getLoginButton().setOnAction(e -> handleLogin());
    }

    private void handleLogin() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        // Basic validation logic (Controller's job)
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Error: Username and Password cannot be empty.");
            return; // Stop here
        }

        // Authenticate (Pretend this is checking the database)
        if (username.equals("admin") && password.equals("password123")) {
            System.out.println("Login Successful! Redirecting...");

            // 1. Create a dummy customer
            Customer customer = new Customer("C0010", "Octrio", "Addaman", "Gaborone", "555-12353");

            // 2. Save them to the database using the DAO
            CustomerDAO dao = new CustomerDAO();
            dao.saveCustomer(customer);

            // 3. Open the dashboard
            AccountView accountView = new AccountView(stage, customer);
            accountView.show();

        } else {
            System.out.println("Error: Invalid credentials. Try admin / password123");
        }
    }
}