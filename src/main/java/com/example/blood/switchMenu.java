package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class switchMenu {
    public static void RegisterMenu(ActionEvent event) throws IOException {
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource("Register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle("Register");
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();
    }
    public static void ForgotPasswordMenu(ActionEvent event) throws IOException {
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource("ForgotPassword.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle("OTP page");
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();
    }
    public static void LoginMenu(ActionEvent event) throws IOException {
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle("Login");
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();
    }
    public static void MainMenu(ActionEvent event) throws IOException {
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle("Main Menu");
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();
    }

    public static void Dashboard(ActionEvent event) throws IOException{
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle("Dashboard");
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();

    }

    public static void DonorDashboard(ActionEvent event) throws IOException{
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource("DonorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle("DonorDashboard");
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();

    }

}
