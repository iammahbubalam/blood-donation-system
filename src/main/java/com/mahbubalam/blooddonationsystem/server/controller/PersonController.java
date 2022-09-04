package com.mahbubalam.blooddonationsystem.server.controller;

import com.mahbubalam.blooddonationsystem.server.entity.Person;
import com.mahbubalam.blooddonationsystem.server.provider.ConnectionProvider;

import java.sql.*;

public class PersonController {
    public static ResultSet savePerson(Person person) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "insert  into  person(blood_group, date_of_birth, email, first_name,last_name,gender,phone_number,address_id,password_id)   values('" + person.getBloodGroup() + "','" + person.getDateOfBirth() + "','" + person.getEmail() + "','" + person.getFirstName() + "','"+ person.getLastName() + "','" + person.getGender() + "','" + person.getPhoneNumber() + "','" + person.getAddressId() + "','" + person.getPasswordId() + "');";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet resultSe = preparedStatement.getGeneratedKeys();

        return resultSe;
    }

}
