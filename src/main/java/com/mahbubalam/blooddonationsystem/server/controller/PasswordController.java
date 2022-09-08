package com.mahbubalam.blooddonationsystem.server.controller;

import com.mahbubalam.blooddonationsystem.server.entity.Password;
import com.mahbubalam.blooddonationsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordController {


    //    public static int savePassword(Password password) throws SQLException, ClassNotFoundException {
//
//        int passwordId=0;
//        Connection connection = ConnectionProvider.createConnection();
//        String addressQuarry = "insert  into  password(password)   values('" + password.getPassword() + "');";
//        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry, Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.executeUpdate();
//        ResultSet resultSet = preparedStatement.getGeneratedKeys();
//        while (resultSet.next()){
//            passwordId=resultSet.getInt(1);
//        }
//
//        return passwordId;
//
//    }
    public static boolean savePassword(Password password) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "insert  into  password(password)   values('" + password.getPassword() + "');";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        boolean a = preparedStatement.execute();
        connection.close();
        return a;


    }

    public static boolean updatePassword(int id, String password) {
        Connection connection = null;
        try {
            connection = ConnectionProvider.createConnection();
            String addressQuarry = "UPDATE password SET password.password = '" + password + "' WHERE password.id='" + id + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean deletePassword(int id) {
        Connection connection = null;
        boolean isDeleted = false;
        try {
            connection = ConnectionProvider.createConnection();
            String addressQuarry = "DELETE from password WHERE password.id='" + id + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
            preparedStatement.execute();
            isDeleted = true;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }


}
