package com.example.blood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label bgrpLabel;
    @FXML
    private Label rhFacLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label email;
    @FXML
    private Label PhoneNum;


    @FXML
    protected void onBackBC(ActionEvent event) throws IOException{
        switchMenu.MainMenu(event);
    }
    @FXML
    protected void onSearchBC(ActionEvent event) throws  IOException{

    }

}
