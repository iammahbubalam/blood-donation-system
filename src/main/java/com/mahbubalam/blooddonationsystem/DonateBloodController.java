package com.mahbubalam.blooddonationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class DonateBloodController extends MainMenuController{
    @FXML
    private ComboBox divisionComboBox;
    @FXML
    private ComboBox districtComboBox;

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
}
