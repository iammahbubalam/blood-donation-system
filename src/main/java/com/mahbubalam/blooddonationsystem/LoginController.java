package com.mahbubalam.blooddonationsystem;

import com.mahbubalam.blooddonationsystem.server.controller.AuthenticationController;
import com.mahbubalam.blooddonationsystem.server.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Objects;

public class LoginController {

    public TextField emailOrPhoneInputField;
    public PasswordField passwordInputField;
    public Text showWarning;
    @FXML
    private Stage loginStage, registerStage;

    @FXML
    private Parent root;


    @FXML
    protected void onLoginButtonClick(ActionEvent event){
        String emailOrPhone = emailOrPhoneInputField.getText();
        String password = passwordInputField.getText();
        boolean isAuthenticate;
        if (emailOrPhone.contains(".com")){
            try {
                isAuthenticate= AuthenticationController.authenticateWithEmail(emailOrPhone,password);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                isAuthenticate=AuthenticationController.authenticateWithPhoneNo(emailOrPhone,password);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

        }
        if (!isAuthenticate){

            showWarning.setText("invalid Email or password");
        }else {
            changeStage(event);
        }
    }

    @FXML
    protected void onRegisterButtonClick(ActionEvent event){
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerview-one.fxml")));
            registerStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            registerStage.setTitle("Blood Bank");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeStage(ActionEvent event){
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainmenu-view.fxml")));
            loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            loginStage.setTitle("Blood Bank");
            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}