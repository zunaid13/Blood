package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdatePasswordController {
    @FXML
    protected TextField password;
    @FXML
    protected TextField recheckPassword;
    @FXML protected Label verdict;
    @FXML protected Label capitalLab;
    @FXML protected Label smallLab;
    @FXML protected Label numberLab;
    @FXML protected Label specialLab;

    @FXML protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
    @FXML protected void onSubmitBC(ActionEvent event) throws IOException {
        // obtaining info
        mySettings.password = password.getText();
        String check = recheckPassword.getText();
        // check passwords and email free

        boolean small = false, capital = false, special = false, number = false;
        for (int i = 0; i < mySettings.password.length(); i++) {
            if (mySettings.password.charAt(i) >= 'a' && mySettings.password.charAt(i) <= 'z')
                small = true;
            else if (mySettings.password.charAt(i) >= 'A' && mySettings.password.charAt(i) <= 'Z')
                capital = true;
            else if (mySettings.password.charAt(i) >= '0' && mySettings.password.charAt(i) <= '9')
                number = true;
            else special = true;
        }
        if (small == false) {
            smallLab.setText("Password must have small letters");
        } else smallLab.setText("Password has small letters");
        if (capital == false) {
            capitalLab.setText("Password must have capital letters");
        } else capitalLab.setText("Password has capital letters");
        if (number == false) {
            numberLab.setText("Password must have numbers");
        } else numberLab.setText("Password has numbers");
        if (special == false) {
            specialLab.setText("Password must have special characters");
        } else specialLab.setText("Password has special characters");

        if(!check.equals(mySettings.password))
        {
            verdict.setText("Password does not match");
            return;
        }
        if(mySettings.password.length() < 8)
        {
            verdict.setText("Password too short");
            return;
        }
        if((small && capital && number && special) != true) return;
        sql.updatePassword();
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
}
