package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {
    @FXML
    protected TextField fullname, email, password, recheckPassword;
    @FXML protected DatePicker DOB_datepicker;
    @FXML protected Label verdict;
    @FXML protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.LoginMenu(event);
    }
    @FXML protected void onSubmitBC(ActionEvent event) throws IOException {
        // obtaining info
        mySettings.fullname = fullname.getText();
        mySettings.email = email.getText();
        mySettings.password = password.getText();
        String check = recheckPassword.getText();
        mySettings.DOB = DOB_datepicker.getValue(); // might cause problems with sql dates
        // check passwords and email free
        if(!check.equals(mySettings.password))
        {
            verdict.setText("Password does not match");
            return;
        }
        if(mySettings.password.length() < 3)
        {
            verdict.setText("Password too short");
            return;
        }
        if(mySettings.fullname.length() < 3)
        {
            verdict.setText("Fullname too short");
            return;
        }
        // check existence of email and if email already exists
        // check if DOB is given or not


        switchMenu.LoginMenu(event);
    }
}
