package com.example.blood;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onExitBC() {
        Platform.exit();
    }
    @FXML protected void onLoginBC(ActionEvent event) throws IOException {
        switchMenu.MainMenu(event);
    }
    @FXML protected void onRegisterBC(ActionEvent event) throws IOException {
        switchMenu.RegisterMenu(event);
    }
}