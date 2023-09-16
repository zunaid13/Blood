package com.example.blood;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label verdict;
    @FXML
    private TextField email;
    @FXML
    private TextField password;

    @FXML
    protected void onExitBC() {
        Platform.exit();
    }
    @FXML protected void onLoginBC(ActionEvent event) throws Exception {
        mySettings.email = email.getText();
        mySettings.password = password.getText();
        if(sql.CheckEmailAvailability())
        {
            verdict.setText("User does not exist");
            return;
        }
        if(!sql.checkPassword())
        {
            verdict.setText("Wrong password");
            return;
        }
        sql.resetOTP();
        sql.fetchUser();
        if(mySettings.division != null)
            switchMenu.MenuSwitch(event, switchMenu.mainMenu, "Main Menu");
        // else go to first login thingy
    }
    @FXML protected void onRegisterBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.registerMenu, "Register");
    }

    @FXML protected void onForgotPasswordBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.forgotPasswordMenu, "Recover account");
    }

}