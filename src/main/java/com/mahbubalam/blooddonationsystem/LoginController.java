package com.mahbubalam.blooddonationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label loginTitle;
    @FXML
    private Stage loginStage, registerStage;

    @FXML
    private Parent root;

    @FXML
    protected void onLoginButtonClick(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("mainmenu-view.fxml"));
            loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            loginStage.setTitle("Blood Bank");
            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onRegisterButtonClick(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("registerview-one.fxml"));
            registerStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            registerStage.setTitle("Blood Bank");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}