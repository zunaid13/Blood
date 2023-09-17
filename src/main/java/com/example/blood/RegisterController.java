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
        if(mySettings.DOB == null)
        {
            verdict.setText("You must select a date of birth");
            return;
        }
        if(Period.between(mySettings.DOB, LocalDate.now()).getYears() < 18)
        {
            verdict.setText("You must be atleast 18 years old");
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
