package com.mahbubalam.blooddonationsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.mahbubalam.blooddonationsystem.server.controller.AddressController;
import com.mahbubalam.blooddonationsystem.server.controller.DonationController;
import com.mahbubalam.blooddonationsystem.server.controller.PersonController;
import com.mahbubalam.blooddonationsystem.server.entity.Address;
import com.mahbubalam.blooddonationsystem.server.entity.BloodGroup;
import com.mahbubalam.blooddonationsystem.server.entity.Donation;
import com.mahbubalam.blooddonationsystem.server.entity.Person;
import com.mahbubalam.blooddonationsystem.server.model.ShowPerson;
import com.mahbubalam.blooddonationsystem.singletron.User;
import com.mahbubalam.blooddonationsystem.socketclint.Reader;
import com.mahbubalam.blooddonationsystem.util.Data;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable, Runnable {
    public Thread readerThread;
    public JFXTextArea textArea;
    public Label addressLabel;
    public Label email;
    public Label dateOfBirth;
    public Label mobileNum;
    public Label gender;
    public Label bloodGroup;
    public Label name;
    public TextField hospitalNameTExtFild;
    public Text warning;
    public TextField textField;
    User user = User.getInstance();
    ShowPerson showPerson;
    String gen;
    Person person;
    Address personAddress;

    public ShowPerson getShowPerson() {
        return showPerson;
    }

    public void setShowPerson(ShowPerson showPerson) {
        this.showPerson = showPerson;
    }

    NetworkUtility networkUtility;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.showPerson=User.getInstance().getShowPerson();
        getPerson();
        name.setText(showPerson.getName());
        email.setText(showPerson.getEmail());
        mobileNum.setText(showPerson.getPhoneNo());
        bloodGroup.setText(showPerson.getBloodGroup());
        dateOfBirth.setText(person.getDateOfBirth());
        gender.setText(person.getGender());

        new Thread(this).start();

    }
    void getPerson(){
        try {
            this.person=PersonController.getPersonById(showPerson.getId());
            this.personAddress= AddressController.getAddressById(showPerson.getId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("www.google.com", 80));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client Started--- ");
        System.out.println(socket.getLocalAddress().getHostAddress());

        try {
            networkUtility = new NetworkUtility(socket.getLocalAddress().getHostAddress(), 9999);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        networkUtility.write(user.getUserId());

        readerThread = new Thread(new Reader(networkUtility, this));

        readerThread.start();
        try {
            readerThread.join();
        } catch (Exception e) {
            System.out.println("Thread exited");
        }
    }

//    words[0] = Sender Id
//    words[1] = Receiver Id
//    words[2] = Sender Name
//    words[3] = keyword
//    words[4] = message/null
    public void onAddressClick(ActionEvent event) {
        addressLabel.setText(personAddress.getCountry() + ", " + personAddress.getDivision() + ", " + personAddress.getDistrict() + ", " + personAddress.getSubDistrict() + ".");

    }

    public void send(ActionEvent event) throws CloneNotSupportedException {
        if (!textField.getText().isBlank()) {
            Data data = new Data();
            data.message = user.getUserId() + "$" + showPerson.getId() + "$" + user.getName() + "$" + "text" + "$" + textField.getText();
            networkUtility.write(data.clone());
            textArea.appendText("\n"+textField.getText() + "\n");
        }
    }

    public void accept(ActionEvent event) throws SQLException, ClassNotFoundException {
        warning.setText("");
        if (user.getMessage() != null) {
            String[] message = user.getMessage().split("\\$");
            DonationController.saveDonation(new Donation(message[3], new Date(new java.util.Date().getTime()), user.getUserId(), showPerson.getId(), BloodGroup.valueOf(user.getBloodGroup())));
            PersonController.setReadyToDonateFalse(user.getUserId());
            PersonController.readyToDonateEvent( user.getUserId());
            warning.setText("donation done");
            hospitalNameTExtFild.setText("");
            textArea.appendText("\nyou accept donation request");
            user.setMessage(null);
        }else warning.setText("no donation request found");

    }

    public void request(ActionEvent event) throws SQLException, ClassNotFoundException, CloneNotSupportedException {
        if (fieldCheck()) {
            if (PersonController.getReadyToDonate(showPerson.getId())) {
                Data data = new Data();
                data.message = user.getUserId() + "$" + showPerson.getId() + "$" + user.getName() + "$" + "requestForBlood" + "$" + hospitalNameTExtFild.getText() ;
                networkUtility.write(data.clone());
                warning.setText("Request Sent");
                textArea.appendText("\nyou sent a donation request ");
            } else warning.setText("Person can not donate blood at this Moment");
            hospitalNameTExtFild.setText("");
        } else warning.setText("Fields can not be empty");
    }

    private boolean fieldCheck() {
        return  !hospitalNameTExtFild.getText().isBlank();
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("BloodBank");
        stage.setScene(new Scene(root));
        Thread.interrupted();
        stage.show();
    }
}
