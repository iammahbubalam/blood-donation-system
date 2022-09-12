package com.mahbubalam.blooddonationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ForgatePasswordController {
    public TextField emailOrPhoneInputField;
    public TextField varificationCodeInputField;
    public Text warning;
    public TextField newPassWordField;
    public TextField confirmPasswordField;
    public Text warning1;
    private Parent root;
    private Stage loginStage;

    public void onLoginButtonClick(ActionEvent event) throws IOException {
        nextPage("login-view.fxml",event);
    }

    public void onClickChangePassword(ActionEvent event) {
    }
    private void nextPage(String name, ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
        loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.setScene(new Scene(root));
        loginStage.show();
    }

    public void onVarifyButtonClic(ActionEvent event) {

    }
}
