package com.example.blood;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BloodDonnor extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BloodDonnor.class.getResource("Login.fxml"));

        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load(), mySettings.Width, mySettings.Height);
        stage.setTitle("Hello!");
        // Image icon = new Image(mySettings.iconPath);
        // stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}