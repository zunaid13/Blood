package com.example.blood;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.Period;


public class donnorThumbnailController {
    @FXML public Label name;
    @FXML public Label bloodGrp;
    @FXML public Label age;
    @FXML public Label Location;
    @FXML public Label Rating;
    public void setup(userProfiler up)
    {
        name.setText(up.fullname);
        bloodGrp.setText(up.bloodgroup + " " + up.rh_factor);
        age.setText(String.valueOf(Period.between(up.DOB, LocalDate.now()).getYears()));
        Location.setText(up.division + ", " + up.district);
        if(up.rating < 0)
            Rating.setText("Unrated");
        else Rating.setText(String.valueOf(up.rating));
        System.out.println("THUMB AREA : " + up.fullname);

    }
}
