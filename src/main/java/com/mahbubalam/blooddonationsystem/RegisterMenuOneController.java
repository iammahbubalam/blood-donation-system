package com.mahbubalam.blooddonationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterMenuOneController implements Initializable {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private ComboBox<String> bloodGroup = new ComboBox<>();
    @FXML
    private ComboBox<String> gender = new ComboBox<>();
    private String[] bloodGroupsList = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
    private String[] genderList = {"male", "female", "other"};
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField weight;
    @FXML
    private Button nextButton;
    @FXML
    private Parent root;
    @FXML
    private Stage registerStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bloodGroup.getItems().addAll(bloodGroupsList);
        gender.getItems().addAll(genderList);
    }

    @FXML
    protected void onClickNextButton(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("registerview-two.fxml"));
            registerStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
