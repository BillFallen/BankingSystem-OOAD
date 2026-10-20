package com.banking.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private Stage stage;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;

    public LoginView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Create UI Components
        Label titleLabel = new Label("Banking System Login");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        usernameField = new TextField();
        usernameField.setPromptText("Enter Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        loginButton = new Button("Log In");

        // Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Username:"), 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);

        VBox root = new VBox(20, titleLabel, grid);
        root.setAlignment(Pos.CENTER);

        // Set the Scene
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Bank System - Login");
        stage.setScene(scene);
        stage.show();
    }

    // Getters for Controller to access the input
    public String getUsername() { return usernameField.getText(); }
    public String getPassword() { return passwordField.getText(); }
    public Button getLoginButton() { return loginButton; }
}