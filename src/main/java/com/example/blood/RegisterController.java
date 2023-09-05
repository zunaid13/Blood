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
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    protected TextField fullname;
    @FXML
    protected TextField email;
    @FXML
    protected TextField password;
    @FXML
    protected TextField recheckPassword;
    @FXML protected DatePicker DOB_datepicker;
    @FXML protected Label verdict;
    @FXML protected ComboBox <String> division;
    @Override public void initialize(URL url, ResourceBundle resourceBundle)
    {
        division.setItems(FXCollections.observableArrayList("Rajshahi", "Rangpur", "Sylhet", "Dhaka", "Khulna", "Barisal", "Chittagong"));
    }
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
        System.out.println(mySettings.DOB);
        mySettings.division = division.getValue();
        // check passwords and email free
        if(mySettings.fullname.length() < 3)
        {
            verdict.setText("Fullname too short");
            return;
        }
        if(mySettings.password.length() < 8)
        {
            verdict.setText("Password too short");
            return;
        }

        boolean small = false, capital = false, num = false, special = false;
        for(int i = 0 ; i < mySettings.password.length() ; i++)
        {
            if(mySettings.password.charAt(i) >= 'a' && mySettings.password.charAt(i) <= 'z')
                small = true;
            else if(mySettings.password.charAt(i) >= 'A' && mySettings.password.charAt(i) <= 'Z')
                capital = true;
            else if(mySettings.password.charAt(i) >= '0' && mySettings.password.charAt(i) <= '9')
                num = true;
            else special = true;
        }
        if(small == false)
        {
            verdict.setText("Password must have at least one small character");
            return;
        }
        if(capital == false)
        {
            verdict.setText("Password must have at least one capital character");
            return;
        }
        if(num == false)
        {
            verdict.setText("Password must have at least one number");
            return;
        }
        if(special == false)
        {
            verdict.setText("Password must have at least one special character");
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
        if(!sql.CheckEmailAvailability())
        {
            verdict.setText("You already have an account");
            return;
        }
        if(mySettings.division == null) {
            verdict.setText("Select your region");
            return;
        }
        // check existence of email and if email already exists
        if(!MailService.sendMail(mySettings.email, MailService.WELCOME_SUBJECT, MailService.WELCOME_TEXT))
        {
            verdict.setText("Please enter a valid email");
            return;
        }
        sql.addUser();
        switchMenu.LoginMenu(event);
    }
}
