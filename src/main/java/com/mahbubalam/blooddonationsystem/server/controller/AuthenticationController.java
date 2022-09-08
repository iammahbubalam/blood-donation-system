package com.mahbubalam.blooddonationsystem.server.controller;

import com.mahbubalam.blooddonationsystem.server.entity.User;
import com.mahbubalam.blooddonationsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationController {
    public static boolean authenticateWithPhoneNo(String phone, String password) throws ClassNotFoundException, SQLException {
        int personId = 0;
        String passwordFromDb = null;
        String phoneNoFromDb = null;
        String emailFromDb = null;
        String parsonName = null;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "SELECT person.id ,person.first_name,person.last_name, person.phone_number , person.email , password.id , password.password FROM person RIGHT JOIN password ON person.password_id=password.id WHERE phone_number='" + phone + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            personId = resultSet.getInt(1);
            parsonName = resultSet.getString(2)+" "+resultSet.getString(3);
            phoneNoFromDb = resultSet.getString(4);
            emailFromDb=resultSet.getString(5);
            passwordFromDb = resultSet.getString(7);
        }

        if (password.equals(passwordFromDb) && phone.equals(phoneNoFromDb)){
            User.getInstance().setUserId(personId);
            User.getInstance().setUserPhoneNo(phoneNoFromDb);
            User.getInstance().setUserEmail(emailFromDb);
            User.getInstance().setName(parsonName);
            return true;
        }

        return false;
    }
    public static boolean authenticateWithEmail(String email, String password) throws ClassNotFoundException, SQLException {
        int personId = 0;
        String passwordFromDb = null;
        String phoneNoFromDb = null;
        String emailFromDb = null;
        String parsonName = null;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "SELECT person.id ,person.first_name,person.last_name, person.phone_number , person.email , password.id , password.password FROM person RIGHT JOIN password ON person.password_id=password.id WHERE email='" + email + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            personId = resultSet.getInt(1);
            parsonName = resultSet.getString(2)+" "+resultSet.getString(3);
            phoneNoFromDb = resultSet.getString(4);
            emailFromDb=resultSet.getString(5);
            passwordFromDb = resultSet.getString(7);

        }

        if (password.equals(passwordFromDb) && email.equals(emailFromDb)){
            User.getInstance().setUserId(personId);
            User.getInstance().setUserPhoneNo(phoneNoFromDb);
            User.getInstance().setUserEmail(emailFromDb);
            User.getInstance().setName(parsonName);
            return true;
        }

        return false;
    }

    public static boolean isAuthentic(String phone, String password) throws ClassNotFoundException, SQLException {
        String pas = null;
        String phoneNO = null;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "SELECT person.id,person.phone_number , person.email , password.id , password.password FROM person RIGHT JOIN password ON person.password_id=password.id WHERE phone_number='" + phone + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            phoneNO = resultSet.getString(2);
            pas = resultSet.getString(5);
        }


        return password.equals(pas) && phone.equals(phoneNO);
    }

    public static boolean changePassword(String phone, String password) throws ClassNotFoundException, SQLException {
        int passwordId = isExist(phone);
        if (passwordId > 0) {
            return PasswordController.updatePassword(passwordId, password);
        }
        return false;
    }

    public static int isExist(String phone) throws ClassNotFoundException, SQLException {
        int passwordId = 0;
        Connection connection = ConnectionProvider.createConnection();
        String personQuarry = "SELECT * From person WHERE  phone_number ='" + phone + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(personQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            passwordId = resultSet.getInt(12);
        }


        return passwordId;
    }
}
