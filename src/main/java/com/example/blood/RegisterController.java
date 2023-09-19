package com.example.blood;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

public class RegisterController {
    @FXML
    protected TextField email;
    @FXML
    protected TextField password;
    @FXML
    protected TextField recheckPassword;
    @FXML protected DatePicker DOB_datepicker;
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
        mySettings.email = email.getText();
        mySettings.password = password.getText();
        String check = recheckPassword.getText();
        mySettings.DOB = DOB_datepicker.getValue(); // might cause problems with sql dates
        System.out.println(mySettings.DOB);
        // check passwords and email free

        //////
        if (mySettings.password.length() < 8) {
            verdict.setText("Password too short");
            return;
        }
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
        /////
        if((small && capital && number && special) != true) return;
//        if(mySettings.passwordCheck(mySettings.password) != null)
//        {
//            verdict.setText(mySettings.passwordCheck(mySettings.password));
//            return;
//        }

        if(!check.equals(mySettings.password))
        {
            verdict.setText("Password does not match");
            return;
        }
        if(mySettings.DOB == null)
        {
            verdict.setText("You must select a date of birth");
            return;
        }
        if(Period.between(mySettings.DOB, LocalDate.now()).getYears() < 18)
        {
            verdict.setText("You must be at least 18 years old");
            return;
        }
        if(!sql.CheckEmailAvailability())
        {
            verdict.setText("You already have an account");
            return;
        }

        verdict.setText("Please wait while we validate the email");
        // check existence of email and if email already exists
        if(!MailService.sendMail(mySettings.email, MailService.WELCOME_SUBJECT, MailService.WELCOME_TEXT))
        {
            verdict.setText("Please enter a valid email");
            return;
        }
        sql.addUser();
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
}
