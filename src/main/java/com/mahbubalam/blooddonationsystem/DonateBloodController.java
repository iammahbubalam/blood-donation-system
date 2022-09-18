package com.mahbubalam.blooddonationsystem;

import com.mahbubalam.blooddonationsystem.server.controller.PersonController;
import com.mahbubalam.blooddonationsystem.server.entity.Person;
import com.mahbubalam.blooddonationsystem.server.model.ShowPerson;
import com.mahbubalam.blooddonationsystem.singletron.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DonateBloodController implements Initializable {

    public ComboBox<String> divisionComboBox;
    public ComboBox<String> districtComboBox;
    public List<Person> personList ;
    private final String[] bloodGroupsList = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
    private final String[] divisionList = {"Dhaka", "Chattogram", "Rajshahi", "Sylhet", "Barisal", "Khulna", "Rangpur",
            "Mymensingh"};
    private final String[] districtList = {"Dhaka","Faridpur","Gazipur","Gopalganj","Jamalpur","Kishoreganj","Madaripur",
            "Manikganj","Munshiganj","Mymensingh","Narayanganj","Narsingdi","Netrokona","Rajbari","Shariatpur",
            "Sherpur","Tangail","Bogra","Joypurhat","Naogaon","Natore","Nawabganj","Pabna","Rajshahi","Sirajgonj",
            "Dinajpur","Gaibandha","Kurigram","Lalmonirhat","Nilphamari","Panchagarh","Rangpur","Thakurgaon","Barguna","Barisal","Bhola","Jhalokati","Patuakhali","Pirojpur","Bandarban","Brahmanbaria","Chandpur","Chattogram","Cumilla","Cox''s Bazar","Feni","Khagrachari","Lakshmipur","Noakhali","Rangamati","Habiganj","Maulvibazar","Sunamganj","Sylhet","Bagerhat","Chuadanga","Jessore","Jhenaidah","Khulna","Kushtia","Magura","Meherpur","Narail","Satkhira"};

    public TableColumn<ShowPerson,String> bloodgroupColumn;
    public TableColumn<ShowPerson,String> phonenumberColumn;
    public TableColumn<ShowPerson,String> nameColumn;
    public TableColumn<ShowPerson,String> emailColumn;
    public TableView<ShowPerson> tableView;
    ObservableList<ShowPerson> personObservableList;
    public void onActionLoadPeople(ActionEvent event) throws SQLException, ClassNotFoundException {
        personObservableList= PersonController.getPersonWhoNeedBlood2();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        bloodgroupColumn.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.setItems(personObservableList);
    }

    public void onClickDistrictComboBox(ActionEvent event) {
    }

    public void onClickDivisionComboBox(ActionEvent event) {
    }
    private void removeMe(){
        for (ShowPerson personList:personObservableList) {
            if (personList.getId()== User.getInstance().getUserId()){
                personObservableList.remove(personList);
            }
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        divisionComboBox.getItems().addAll(divisionList);
        districtComboBox.getItems().addAll(districtList);
        try {
         //   PersonController.setNeedBloodFalse(User.getInstance().getUserId());
            this.personList= PersonController.getPersonWhoReadyToDonate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
