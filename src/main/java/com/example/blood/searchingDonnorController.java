package com.example.blood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class searchingDonnorController implements Initializable {

    @FXML
    private ComboBox<String> District;

    @FXML
    private ComboBox<String> Division;

    @FXML
    private ComboBox<String> bloodgroup;

    @FXML
    private GridPane gridPain;

    @FXML
    private ComboBox<String> rh_factor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<userProfiler> others = sql.getOtherProfiles();
        for(int i = 0 ; i < others.size() ; i++)
        {
            if(others.get(i).district == null) continue;
            System.out.println("Obtained email: " + others.get(i).email);
            FXMLLoader loader = new FXMLLoader(BloodDonnor.class.getResource(switchMenu.donnorThumb));
            try{
                Parent root = loader.load();
                donnorThumbnailController dtc = loader.getController();
                dtc.setup(others.get(i));
                int x =  1, y =  1+i;
                gridPain.add(root, x, y);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onBackBC(ActionEvent event) throws IOException {
        switchMenu.MenuSwitch(event, switchMenu.mainMenu,"Main Menu");
    }
}
