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

    @FXML protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
    @FXML protected void onSubmitBC(ActionEvent event) throws IOException {
        // obtaining info
        mySettings.password = password.getText();
        String check = recheckPassword.getText();
        // check passwords and email free

        if(mySettings.passwordCheck(mySettings.password) != null)
        {
            verdict.setText(mySettings.passwordCheck(mySettings.password));
            return;
        }

        if(!check.equals(mySettings.password))
        {
            verdict.setText("Password does not match");
            return;
        }

        sql.updatePassword();
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
}
