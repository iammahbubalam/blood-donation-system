package com.mahbubalam.blooddonationsystem;


import com.mahbubalam.blooddonationsystem.server.controller.*;

import com.mahbubalam.blooddonationsystem.server.entity.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws SQLException, ClassNotFoundException, ParseException {
//        Connection connection= ConnectionProvider.createConnection();
        Address address = new Address("Chittagong", "Chandpur", "hajigonj", null);
//        String addressQuarry = "insert  into  address(country, district, division, sub_district)   values('"+address.getCountry()+"','"+address.getDivision()+"','"+address.getDistrict()+"','"+address.getSubDistrict()+"');";
////        String passwordQuarry = "insert  into  Password(password)  values(?);";
////        String quarry = "insert into  Person(address_id, blood_group, date_of_birth, email, firstName, gender, lastName, password_id, phone_number, ready_to_donate) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
//        preparedStatement.execute();
//        ResultSet resultSet = AddressController.saveAddress(address);
        Date date = new Date();
        java.sql.Date dateDB = new java.sql.Date(date.getTime());
//        //save password
        int r1 =AddressController.saveAddress(new Address("Dhaka","badda","vatara"));

        int r2 = PasswordController.savePassword(new Password("iammahbubalam"));

        Person person = new Person("mahbub","alam","01726131573","bubhamnojrin71960000002gmail.com",dateDB, BloodGroup.O_POSITIVE, Gender.MALE,r1 ,r2);
        ResultSet resultSet = PersonController.savePerson(person);
        if(resultSet != null && resultSet.next()){
            System.out.println("Generated Emp Id: "+resultSet.getInt(1));
        }
//        System.out.println();
        //update password
//        int resultSet = AuthenticationController.isAuthenticate("01245487875","sanju");
//        if (resultSet>0) System.out.println("found");
//        else System.out.println("something wrong");

        welcomeText.setText("Welcome to JavaFX Application!");
    }
}