package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.io.IOException;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String temp = formatter.format(date);
    @FXML
    Label Dt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Dt.setText("Today's Date: " + temp);
    }
    @FXML protected void onLogoutBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.loginMenu, "Login");
    }
    @FXML protected void onLearnBC(ActionEvent event) throws IOException {
        mybrowser.Goto(mybrowser.google);
    }
    @FXML protected void onSearchDonnorBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.searchDonnor, "Searching for Donors");
    }
    @FXML protected void onViewProfileBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.donnorDashboard, "My profile");
    }
}
