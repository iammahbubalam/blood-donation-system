package com.mahbubalam.blooddonationsystem;

import com.mahbubalam.blooddonationsystem.server.controller.AddressController;
import com.mahbubalam.blooddonationsystem.server.controller.DonationController;
import com.mahbubalam.blooddonationsystem.server.controller.PersonController;
import com.mahbubalam.blooddonationsystem.server.entity.Address;
import com.mahbubalam.blooddonationsystem.server.entity.Donation;
import com.mahbubalam.blooddonationsystem.server.entity.Person;
import com.mahbubalam.blooddonationsystem.server.model.ShowPerson;
import com.mahbubalam.blooddonationsystem.singletron.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
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
    public TableColumn<Donation,String> hospitalColumn;
    public TableColumn<Donation, Date> dateColumn;
    public TableView<Donation> table;
    User user = User.getInstance();
    Person person;
    Address personAddress;
    ObservableList<Donation> donationObservableList;


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
        address.setText(personAddress.getCountry() + ", " + personAddress.getDivision() + ", " + personAddress.getDistrict() + ", " + personAddress.getSubDistrict() + ".");

    }

    public void donationData(ActionEvent event) throws SQLException, ClassNotFoundException {
        hospitalColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("donationDate"));
        donationObservableList=DonationController.getDonatedDonationById(User.getInstance().getUserId());
        table.setItems(donationObservableList);
    }

    public void receivedData(ActionEvent event) throws SQLException, ClassNotFoundException {
        hospitalColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("donationDate"));
        donationObservableList=DonationController.getReceivedDonationById(User.getInstance().getUserId());
        table.setItems(donationObservableList);

    }
}
