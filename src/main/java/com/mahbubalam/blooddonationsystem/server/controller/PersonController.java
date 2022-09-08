package com.mahbubalam.blooddonationsystem.server.controller;

import com.mahbubalam.blooddonationsystem.server.entity.BloodGroup;
import com.mahbubalam.blooddonationsystem.server.entity.Gender;
import com.mahbubalam.blooddonationsystem.server.model.Person;
import com.mahbubalam.blooddonationsystem.server.provider.ConnectionProvider;

import java.sql.*;

public class PersonController {

    public static void savePerson( String firstName,String lastName,String phoneNo,String email, String dateOfBirth, BloodGroup bloodGroup, Gender gender) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "insert  into  person(blood_group, date_of_birth, email, first_name,last_name,gender,phone_number,address_id,password_id)   values('" + bloodGroup + "','" + dateOfBirth + "','" + email + "','" +firstName + "','"+ lastName + "','" + gender + "','" + phoneNo +"',(SELECT MAX( id ) FROM address),(SELECT MAX( id ) FROM password));";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
         preparedStatement.execute();


    }


}
