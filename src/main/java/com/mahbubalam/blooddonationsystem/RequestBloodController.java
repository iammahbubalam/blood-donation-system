package com.mahbubalam.blooddonationsystem;


import com.mahbubalam.blooddonationsystem.server.controller.PersonController;
import com.mahbubalam.blooddonationsystem.server.entity.Person;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RequestBloodController implements Initializable {

    public ComboBox<String> bloodGroupComboBox;
    public ComboBox<String> divisionComboBox;
    public ComboBox<String> districtComboBox;
    public List<Person> personList ;
    private final String[] bloodGroupsList = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
    private final String[] divisionList = {"Dhaka", "Chattogram", "Rajshahi", "Sylhet", "Barisal", "Khulna", "Rangpur",
            "Mymensingh"};
    private final String[] districtList = {"Dhaka","Faridpur","Gazipur","Gopalganj","Jamalpur","Kishoreganj","Madaripur",
            "Manikganj","Munshiganj","Mymensingh","Narayanganj","Narsingdi","Netrokona","Rajbari","Shariatpur","Sherpur","Tangail","Bogra","Joypurhat","Naogaon","Natore","Nawabganj","Pabna","Rajshahi","Sirajgonj","Dinajpur","Gaibandha","Kurigram","Lalmonirhat","Nilphamari","Panchagarh","Rangpur","Thakurgaon","Barguna","Barisal","Bhola","Jhalokati","Patuakhali","Pirojpur","Bandarban","Brahmanbaria","Chandpur","Chittagong","Comilla","Cox''s Bazar","Feni","Khagrachari","Lakshmipur","Noakhali","Rangamati","Habiganj","Maulvibazar","Sunamganj","Sylhet","Bagerhat","Chuadanga","Jessore","Jhenaidah","Khulna","Kushtia","Magura","Meherpur","Narail","Satkhira"};


    public void onClickLoadButton(ActionEvent event) {
    }

    public void onClickBloodGroupComboBox(ActionEvent event) {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bloodGroupComboBox.getItems().addAll(bloodGroupsList);
        divisionComboBox.getItems().addAll(divisionList);
        districtComboBox.getItems().addAll(districtList);
        try {
            this.personList= PersonController.getPersonWhoReadyToDonate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void onClickDistrictComboBox(ActionEvent event) {
    }

    public void onClickDivisionComboBox(ActionEvent event) {
    }
}
