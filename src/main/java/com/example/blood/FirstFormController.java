package com.example.blood;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FirstFormController implements Initializable {
    @FXML protected TextField fullname;
    @FXML protected ComboBox <String> Gender;
    @FXML protected TextField weight;
    @FXML protected ComboBox <String> bloodGroup;
    @FXML protected ComboBox <String> rhFactor;
    @FXML protected TextField ContactNumber;
    @FXML protected ComboBox <String> Division;
    @FXML protected ComboBox <String> District;
    @FXML protected Label verdict;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("First form initialize start");
        Gender.setItems(FXCollections.observableArrayList("Female", "Male"));
        bloodGroup.setItems(FXCollections.observableArrayList("A", "B", "AB", "O"));
        rhFactor.setItems(FXCollections.observableArrayList("+ve", "-ve"));
        Division.setItems(FXCollections.observableArrayList("Dhaka", "Chattogram"));
        District.setItems(FXCollections.observableArrayList());
        //Barishal, Chattogram, Dhaka, Khulna, Rajshahi, Rangpur, Mymensingh and Sylhet.
        System.out.println("First form initialize finish");
    }
    @FXML protected void updateDistrict()
    {
        District.setItems(FXCollections.observableArrayList());
        System.out.println("Division selected is " + Division.getValue());
        ArrayList <String> dist = sql.getDistricts(Division.getValue());
        for(int i = 0 ; i < dist.size() ; i++)
        {
            District.getItems().add(dist.get(i));
        }
    }

    @FXML protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
    @FXML protected void onProceedBC(ActionEvent event) throws IOException {
        mySettings.fullname = fullname.getText();
        if(mySettings.fullname.length() < 3)
        {
            verdict.setText("Please provide full name");
            return;
        }
        mySettings.gender = Gender.getValue();
        if(mySettings.gender == null)
        {
            verdict.setText("Please select a gender");
            return;
        }
        if(weight.getText() == null)
        {
            verdict.setText("Weight must be a positive number");
            return;
        }
        try{
            mySettings.weight = Double.parseDouble(weight.getText());
        } catch (NumberFormatException nfe)
        {
            verdict.setText("Weight must be a positive number");
            return;
        }
        if(mySettings.weight < 0)
        {
            verdict.setText("Weight must be a positive number");
            return;
        }
        mySettings.bloodgroup = bloodGroup.getValue();
        if(mySettings.bloodgroup == null)
        {
            verdict.setText("Blood group cannot be empty");
            return;
        }
        mySettings.rh_factor = rhFactor.getValue();
        if(mySettings.rh_factor == null)
        {
            verdict.setText("RH factor cannot be empty");
            return;
        }
        mySettings.contact_no = ContactNumber.getText();
        if(mySettings.contact_no.length() < 3)
        {
            verdict.setText("Please enter your contact number");
            return;
        }
        mySettings.division = Division.getValue();
        if(mySettings.division == null)
        {
            verdict.setText("Please enter your division and district");
            return;
        }
        mySettings.district = District.getValue();
        if(mySettings.district == null)
        {
            verdict.setText("Please enter your district");
            return;
        }
        System.out.println("Switching to main menu from first login form");
        sql.updateUser();
        switchMenu.MenuSwitch(event, switchMenu.mainMenu, "Main Menu");
    }
}
