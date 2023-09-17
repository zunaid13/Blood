package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {
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
