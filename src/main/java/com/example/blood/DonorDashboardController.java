package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public class DonorDashboardController {
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
    private Label lastDonatedLabel;
    @FXML
    private Label TimesDonatedLabel;
    @FXML
    private Label ratingLabel;
    @FXML
    private Label email;
    @FXML
    private Label PhoneNum;



    @FXML
    protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MainMenu(event);
    }
    @FXML
    protected void onUpdateBC(ActionEvent event) throws IOException {
        
    }

}
