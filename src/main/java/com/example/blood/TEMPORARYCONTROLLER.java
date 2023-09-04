package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TEMPORARYCONTROLLER {
    @FXML
    private TextField email;
    @FXML
    protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.LoginMenu(event);
    }

    @FXML protected void onSubmitBC(ActionEvent event) throws IOException {
        mySettings.email = email.getText();
        sql.setOTP();
        switchMenu.LoginMenu(event);
    }
}
