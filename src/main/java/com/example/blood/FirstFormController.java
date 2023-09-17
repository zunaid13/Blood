package com.example.blood;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstFormController implements Initializable {
    @FXML public TextField fullname;
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
        District.setItems(sql.getDistricts(Division.getValue()));
    }

    @FXML protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
    @FXML protected void onProceedBC(ActionEvent event) throws IOException {


        switchMenu.MenuSwitch(event, switchMenu.mainMenu, "com.example.blood.Main Menu");
    }
}
