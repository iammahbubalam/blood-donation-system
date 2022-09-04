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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterMenuTwoController implements Initializable {
    public TextField thana;
    @FXML
    private TextField email;
    @FXML
    private TextField mobileNum;
    @FXML
    private TextField nidNum;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> division = new ComboBox<>();
    private String[] divisionList = {"Dhaka", "Chattogram", "Rajshahi", "Sylhet", "Barisal", "Khulna", "Rangpur",
            "Mymensingh"};
    @FXML
    private ComboBox<String> district = new ComboBox<>();
    private String[] districtList = {"Dhaka","Faridpur","Gazipur","Gopalganj","Jamalpur","Kishoreganj","Madaripur",
            "Manikganj","Munshiganj","Mymensingh","Narayanganj","Narsingdi","Netrokona","Rajbari","Shariatpur","Sherpur","Tangail","Bogra","Joypurhat","Naogaon","Natore","Nawabganj","Pabna","Rajshahi","Sirajgonj","Dinajpur","Gaibandha","Kurigram","Lalmonirhat","Nilphamari","Panchagarh","Rangpur","Thakurgaon","Barguna","Barisal","Bhola","Jhalokati","Patuakhali","Pirojpur","Bandarban","Brahmanbaria","Chandpur","Chittagong","Comilla","Cox''s Bazar","Feni","Khagrachari","Lakshmipur","Noakhali","Rangamati","Habiganj","Maulvibazar","Sunamganj","Sylhet","Bagerhat","Chuadanga","Jessore","Jhenaidah","Khulna","Kushtia","Magura","Meherpur","Narail","Satkhira"};
    @FXML
    private Button registerButton;
    @FXML
    private Parent root;
    @FXML
    private Stage registerStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        division.getItems().addAll(divisionList);
        district.getItems().addAll(districtList);
    }

    @FXML
    protected void onClickRegisterButton(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
            registerStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
