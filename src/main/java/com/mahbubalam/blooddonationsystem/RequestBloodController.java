package com.mahbubalam.blooddonationsystem;


import com.mahbubalam.blooddonationsystem.server.controller.PersonController;
import com.mahbubalam.blooddonationsystem.server.model.ShowPerson;
import com.mahbubalam.blooddonationsystem.singletron.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class RequestBloodController implements Initializable {

    public ComboBox<String> bloodGroupComboBox;
    public ComboBox<String> divisionComboBox;
    public ComboBox<String> districtComboBox;
       public TableColumn<ShowPerson,String> bloodgroupColumn;
    public TableColumn<ShowPerson,String> phonenumberColumn;
    public TableColumn<ShowPerson,String> nameColumn;
    public TableColumn<ShowPerson,String> emailColumn;
    public TableView<ShowPerson> tableView;
    public TableColumn<ShowPerson,String> id;
    ShowPerson person;
    ObservableList<ShowPerson> personObservableList;


    public void onClickLoadButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        personObservableList=PersonController.getPersonWhoReadyToDonate2();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        bloodgroupColumn.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        tableView.setItems(personObservableList);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            PersonController.setNeedBloodTrue(User.getInstance().getUserId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    public void omMouseClick(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 1) //Checking double click
        {
            person = tableView.getSelectionModel().getSelectedItem();
            User.getInstance().setShowPerson(person);
        }
        if (mouseEvent.getClickCount() == 2) //Checking double click
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("req-user-profile-view.fxml")));
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("BloodBank");
            stage.setScene(new Scene(root));
            stage.show();
        }

    }
}
