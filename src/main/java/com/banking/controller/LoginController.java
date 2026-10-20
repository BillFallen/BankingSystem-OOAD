package com.banking.controller;

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

            // Create a dummy customer (Later, we will fetch this from the DAO)
            Customer customer = new Customer("C001", "Kevin", "Walker", "Gaborone", "555-1234");

            // Open the dashboard
            AccountView accountView = new AccountView(stage, customer);
            accountView.show();
        } else {
            System.out.println("Error: Invalid credentials. Try admin / password123");
        }
    }
}