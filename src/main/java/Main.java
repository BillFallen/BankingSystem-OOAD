package com;

import com.banking.controller.LoginController;
import com.banking.view.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Create the View
        LoginView loginView = new LoginView(primaryStage);

        // 2. Show the View FIRST (so the buttons are created in memory)
        loginView.show();

        // 3. THEN create the Controller and pass it the View
        LoginController loginController = new LoginController(loginView, primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}