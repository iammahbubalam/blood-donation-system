package com.mahbubalam.blooddonationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BloodBankApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        primaryStage.setTitle("Blood Bank");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("C:\\Users\\Subhey\\Documents\\Github\\Java_Learning\\blood-donation-system\\src\\main\\resources\\com\\mahbubalam\\blooddonationsystem\\Rokto2.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

