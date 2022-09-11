package com.mahbubalam.blooddonationsystem;

import com.jfoenix.controls.JFXButton;
import com.mahbubalam.blooddonationsystem.server.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    public JFXButton userProfileButton;
    public JFXButton logOutButton;
    public JFXButton requestBloodButton;
    public JFXButton donateBloodButton;
    User user = User.getInstance();
    @FXML
    private Label bloodGroup;
    @FXML
    private Label gender;
    @FXML
    private Label editProfileButton;
    /*@FXML
    private Label firstName;
    @FXML
    private Label lastName;*/
    @FXML
    private Label name;
    @FXML
    private Label nidNum;
    @FXML
    private Label mobileNum;
    @FXML
    private Label email;
    @FXML
    private Label address;
    @FXML
    private Parent root;
    @FXML
    private Stage mainMenuStage;
    @FXML
    private Circle circle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img = new Image("C:\\Users\\subhe\\Documents\\Important Documents\\Programming\\Java Programming\\JavaPracticeProject5\\blood-donation-system\\src\\Screenshot 2022-02-11 004828.png");
        circle.setFill(new ImagePattern(img));
    }

    @FXML
    protected void onClickEditProfileButton(ActionEvent event) {
        try {
            //AnchorPane view = FXMLLoader.load(getClass().getResource("editprofile-view.fxml"));

//            root = FXMLLoader.load(getClass().getResource(""));
//            mainMenuStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            mainMenuStage.setTitle("Blood Bank");
//            mainMenuStage.setScene(new Scene(root));
//            mainMenuStage.show();
            name.setText(user.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickUserProfileButton(ActionEvent event) {
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

    @FXML
    public void onClickRequestBloodButton(ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("requestblood-view.fxml")));
            mainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainMenuStage.setTitle("BloodBank");
            mainMenuStage.setScene(new Scene(root));
            mainMenuStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickDonateBloodButton(ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("donateblood-view.fxml")));
            mainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainMenuStage.setTitle("BloodBank");
            mainMenuStage.setScene(new Scene(root));
            mainMenuStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickLogOutButton(ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
            mainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainMenuStage.setTitle("BloodBank");
            mainMenuStage.setScene(new Scene(root));
            mainMenuStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
