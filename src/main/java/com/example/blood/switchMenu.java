package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class switchMenu {
    public static String registerMenu = "Register.fxml";
    public static String forgotPasswordMenu = "ForgotPassword.fxml";
    public static String loginMenu = "Login.fxml";
    public static String mainMenu = "MainMenu.fxml";
    public static void MenuSwitch(ActionEvent event, String fxmlName, String title) throws IOException {
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle(title);
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();
    }

}
