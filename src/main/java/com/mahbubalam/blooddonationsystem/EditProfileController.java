package com.mahbubalam.blooddonationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditProfileController extends MainMenuController implements Initializable {
    @FXML
    private ComboBox<String> bloodGroup = new ComboBox<>();
    @FXML
    private ComboBox<String> gender = new ComboBox<>();
    private String[] bloodGroupsList = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
    private String[] genderList = {"male", "female", "other"};

    @FXML
    private Parent root;
    @FXML
    private Stage mainMenuStage;

    public void initialize(URL arg0, ResourceBundle arg1) {
        bloodGroup.getItems().addAll(bloodGroupsList);
        gender.getItems().addAll(genderList);
    }

    @Override
    public void onClickUserProfileButton(ActionEvent event) {
        super.onClickUserProfileButton(event);
    }

    @Override
    public void onClickLogOutButton(ActionEvent event) {
        super.onClickLogOutButton(event);
    }

    @FXML
    public void onClickSaveButton(ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainmenu-view.fxml")));
            mainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainMenuStage.setTitle("BloodBank");
            mainMenuStage.setScene(new Scene(root));
            mainMenuStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
