package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgotPasswordController {
    @FXML
    private TextField email;
    @FXML private Label verdict;
    @FXML
    protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }

    @FXML protected void onSubmitBC(ActionEvent event) throws IOException {
        mySettings.email = email.getText();
        mySettings.otp = "";
        sql.fetchUser();
        if(mySettings.otp.length() == 0)
        {
            verdict.setText("User does not exist");
            return;
        }
        sql.setOTP();
        switchMenu.MenuSwitch(event, switchMenu.EnterOTP, "Account recovery");
    }
}
