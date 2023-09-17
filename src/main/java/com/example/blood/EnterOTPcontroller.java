package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EnterOTPcontroller {
    @FXML
    private TextField otpField;
    @FXML private Label verdict;
    @FXML
    protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.forgotPasswordMenu, "Recover Account");
    }
    @FXML
    protected void onSubmitBC(ActionEvent event) throws IOException{
        if(otpField.getText().equals(mySettings.otp))
        {
            switchMenu.MenuSwitch(event, switchMenu.UpdatePassword, "Update your password");
        }
        else
        {
            verdict.setText("OTP incorrect");
            return;
        }
        // change password region
    }
}
