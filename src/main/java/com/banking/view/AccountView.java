package com.banking.view;

import com.banking.model.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountView {
    private Stage stage;
    private Customer customer;

    public AccountView(Stage stage, Customer customer) {
        this.stage = stage;
        this.customer = customer;
    }

    public void show() {
        // Top: Header with Customer Name
        Label headerLabel = new Label("Welcome, " + customer.getFullName());
        headerLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button logoutButton = new Button("Log Out");

        HBox topBar = new HBox(20, headerLabel, logoutButton);
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setPadding(new Insets(10));
        topBar.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc;");

        // Left: List of Accounts
        Label accountsLabel = new Label("Your Accounts:");
        ListView<String> accountList = new ListView<>();
        // We'll populate this later with real data
        accountList.getItems().add("Savings Account: BWP 1,000.00");
        accountList.getItems().add("Investment Account: BWP 5,000.00");

        VBox leftPanel = new VBox(10, accountsLabel, accountList);
        leftPanel.setPadding(new Insets(10));
        leftPanel.setPrefWidth(250);

        // Center: Action Buttons
        Button depositBtn = new Button("Deposit Funds");
        Button withdrawBtn = new Button("Withdraw Funds");
        Button historyBtn = new Button("View History");

        VBox centerPanel = new VBox(20, depositBtn, withdrawBtn, historyBtn);
        centerPanel.setAlignment(Pos.CENTER);
        centerPanel.setPadding(new Insets(20));

        // Layout Assembly
        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setLeft(leftPanel);
        root.setCenter(centerPanel);

        // Logout Logic (For now, just closes the window)
        logoutButton.setOnAction(e -> stage.close());

        // Set Scene
        Scene scene = new Scene(root, 700, 400);
        stage.setTitle("Bank System - Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}