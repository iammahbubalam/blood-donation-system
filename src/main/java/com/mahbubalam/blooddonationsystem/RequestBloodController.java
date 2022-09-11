package com.mahbubalam.blooddonationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class RequestBloodController extends MainMenuController{
    @FXML
    private ComboBox divisionComboBox;
    @FXML
    private ComboBox districtComboBox;
    @FXML
    private ComboBox bloodGroupComboBox;
    @FXML
    private ComboBox genderComboBox;

    @Override
    public void onClickUserProfileButton(ActionEvent event) {
        super.onClickUserProfileButton(event);
    }

    @Override
    public void onClickRequestBloodButton(ActionEvent event) {
        super.onClickRequestBloodButton(event);
    }

    @Override
    public void onClickDonateBloodButton(ActionEvent event) {
        super.onClickDonateBloodButton(event);
    }

    @Override
    public void onClickLogOutButton(ActionEvent event) {
        super.onClickLogOutButton(event);
    }

    public void onClickBloodGroupComboBox(ActionEvent event) {
    }

    public void onClickGenderComboBox(ActionEvent event) {
    }
}
