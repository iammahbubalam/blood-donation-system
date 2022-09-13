package com.mahbubalam.blooddonationsystem;

import com.mahbubalam.blooddonationsystem.server.controller.AddressController;
import com.mahbubalam.blooddonationsystem.server.controller.PersonController;
import com.mahbubalam.blooddonationsystem.server.entity.Address;
import com.mahbubalam.blooddonationsystem.server.entity.Person;
import com.mahbubalam.blooddonationsystem.singletron.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    public Label address;
    public Label email;
    public Label mobileNum;
    public Label bloodGroup;
    public Label name;
    public Label gender;
    public Label dateOfBirth;
    User user = User.getInstance();
    Person person;
    Address personAddress;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            person = PersonController.getPersonById(user.getUserId());

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        name.setText(person.getFirstName() + " " + person.getLastName());
        bloodGroup.setText(person.getBloodGroup());
        gender.setText(person.getGender());
        dateOfBirth.setText(person.getDateOfBirth());
        email.setText(person.getEmail());
        mobileNum.setText(person.getPhoneNumber());

    }

    public void onAddressClick(ActionEvent event) {
        try {
            personAddress = AddressController.getAddressById(person.getAddressId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        address.setText(personAddress.getCountry() + ", " + personAddress.getDivision() + ", " + personAddress.getDivision() + ", " + personAddress.getSubDistrict() + ".");

    }
}
