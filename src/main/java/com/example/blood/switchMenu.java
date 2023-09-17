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
    public static String EnterOTP = "EnterOTP.fxml";
    public static String UpdatePassword = "UpdatePassword.fxml";
    public static String firstForm = "FirstForm.fxml";
    public static String donnorDashboard = "DonorDashboard.fxml";
    public static String donnorThumb = "donnorThumbnail.fxml";
    public static String searchDonnor = "searchingDonor.fxml";
    public static void MenuSwitch(ActionEvent event, String fxmlName, String title) throws IOException {
        System.out.println("Switching menu to " + fxmlName);
        Node CallingButton = (Node) event.getSource();
        Stage mystage = (Stage) CallingButton.getScene().getWindow();
        mystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load());
        mystage.setTitle(title);
        mystage.setScene(scene);
        mystage.centerOnScreen();
        mystage.show();
        System.out.println("Switching menu complete " + fxmlName);
    }

}
