package com.mahbubalam.blooddonationsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.mahbubalam.blooddonationsystem.server.controller.DonationController;
import com.mahbubalam.blooddonationsystem.server.controller.PersonController;
import com.mahbubalam.blooddonationsystem.server.entity.BloodGroup;
import com.mahbubalam.blooddonationsystem.server.entity.Donation;
import com.mahbubalam.blooddonationsystem.singletron.User;
import com.mahbubalam.blooddonationsystem.socketclint.Reader;
import com.mahbubalam.blooddonationsystem.util.Data;
import com.mahbubalam.blooddonationsystem.util.NetworkUtility;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable, Runnable {
    public int clintId;
    public Thread readerThread;
    public Thread writerThread;
    public JFXTextArea textArea;
    public Label address;
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
    int userId =3;
    NetworkUtility networkUtility;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(this).start();
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

    }

    public void send(ActionEvent event) throws CloneNotSupportedException {
        if (!textField.getText().isBlank()) {
            Data data = new Data();
            data.message = user.getUserId() + "$" + userId + "$" + user.getName() + "$" + "text" + "$" + textField.getText();
            networkUtility.write(data.clone());
            textArea.appendText(textField.getText() + "\n");
        }
    }

    public void accept(ActionEvent event) throws SQLException, ClassNotFoundException {
        warning.setText("");
        if (user.getMessage() != null) {
            System.out.println(user.getBloodGroup()+"from user profile controller");
            String[] message = user.getMessage().split("\\$");
            DonationController.saveDonation(new Donation(message[3], new Date(new java.util.Date().getTime()), user.getUserId(), userId, BloodGroup.valueOf(user.getBloodGroup())));
            PersonController.setReadyToDonateFalse(user.getUserId());
            PersonController.readyToDonateEvent( user.getUserId());
            warning.setText("donation done");
            hospitalNameTExtFild.setText("");
            textArea.appendText("you accept donation request");
            user.setMessage(null);
        }else warning.setText("no donation request found");

    }

    public void request(ActionEvent event) throws SQLException, ClassNotFoundException, CloneNotSupportedException {
        if (fieldCheck()) {
            if (PersonController.getReadyToDonate(userId)) {
                Data data = new Data();
                data.message = user.getUserId() + "$" + userId + "$" + user.getName() + "$" + "requestForBlood" + "$" + hospitalNameTExtFild.getText() ;
                networkUtility.write(data.clone());
                warning.setText("Request Sent");
                textArea.appendText("you sent a donation request ");
            } else warning.setText("Person can not donate blood at this Moment");
            hospitalNameTExtFild.setText("");
        } else warning.setText("Fields can not be empty");
    }

    private boolean fieldCheck() {
        return  !hospitalNameTExtFild.getText().isBlank();
    }
}
