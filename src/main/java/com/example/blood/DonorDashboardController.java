package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

public class DonorDashboardController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(mySettings.fullname);
        ageLabel.setText(String.valueOf(Period.between(mySettings.DOB, LocalDate.now()).getYears()) + " Years");
        bgrpLabel.setText(mySettings.bloodgroup);
        rhFacLabel.setText(mySettings.rh_factor);
        locationLabel.setText(mySettings.division + ", " + mySettings.district);
        weightLabel.setText(String.valueOf(mySettings.weight));
        if(mySettings.lastDonated != null)
            lastDonatedLabel.setText(String.valueOf(mySettings.lastDonated));
        else lastDonatedLabel.setText("Not donated yet");
        TimesDonatedLabel.setText(String.valueOf(mySettings.TotalDonated));
        if(mySettings.rating == -1)
            ratingLabel.setText("Unrated");
        else
            ratingLabel.setText(String.valueOf(mySettings.rating));
        email.setText(mySettings.email);
        PhoneNum.setText(mySettings.contact_no);
    }

    @FXML
    protected void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.mainMenu, "Main Menu");
    }
    @FXML
    protected void onUpdateBC(ActionEvent event) throws IOException {
        
    }

}
