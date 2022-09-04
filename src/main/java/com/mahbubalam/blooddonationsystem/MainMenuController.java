package com.mahbubalam.blooddonationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    private ComboBox bloodGroup;
    @FXML
    private ComboBox gender;
    @FXML
    private Button editProfileButton;
    public Button userProfileButton;
    public Button logOutButton;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField nidNum;
    @FXML
    private TextField mobileNum;
    @FXML
    private TextField email;
    @FXML
    private TextField address;
    @FXML
    private Parent root;
    @FXML
    private Stage mainMenuStage;

    @FXML
    protected void onClickEditProfileButton(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("editprofile-view.fxml"));
            mainMenuStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            mainMenuStage.setTitle("Blood Bank");
            mainMenuStage.setScene(new Scene(root));
            mainMenuStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void onClickUserProfileButton(ActionEvent event){
        try{
            root = FXMLLoader.load(getClass().getResource("mainmenu-view.fxml"));
            mainMenuStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            mainMenuStage.setTitle("BloodBank");
            mainMenuStage.setScene(new Scene(root));
            mainMenuStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickLogOutButton(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
            mainMenuStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            mainMenuStage.setTitle("BloodBank");
            mainMenuStage.setScene(new Scene(root));
            mainMenuStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
