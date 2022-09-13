package com.mahbubalam.blooddonationsystem.server.controller;

import com.mahbubalam.blooddonationsystem.server.entity.*;
import com.mahbubalam.blooddonationsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonController {

    public static void savePerson(String firstName, String lastName, String phoneNo, String email, String dateOfBirth, BloodGroup bloodGroup, Gender gender) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "insert  into  person(blood_group, date_of_birth, email, first_name,last_name,gender,phone_number,ready_to_donate,need_blood,address_id,password_id)   values('" + bloodGroup + "','" + dateOfBirth + "','" + email + "','" + firstName + "','" + lastName + "','" + gender + "','" + phoneNo + "',1,0,(SELECT MAX( id ) FROM address),(SELECT MAX( id ) FROM password));";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.execute();
    }

    public static List<Person> getAllPerson() throws SQLException, ClassNotFoundException {
        String addressQuarry = "SELECT * FROM person;";
        return getPersonList(addressQuarry);
    }
    public static Person getPersonById(int id) throws SQLException, ClassNotFoundException {

        String quarry = "SELECT  * FROM person WHERE id='"+id+"';";
        return getPerson(quarry);
    }

    public static Person getPersonByPhone(String phoneNo) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  * FROM person WHERE phone_number='"+phoneNo+"';";
        return getPerson(quarry);

    }
    public static  List<Person> getPersonWhoReadyToDonate() throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  * FROM person WHERE ready_to_donate = 1;";
        return getPersonList(quarry);


    }
    public static  List<Person> getPersonWhoNeedBlood() throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  * FROM person WHERE need_blood = 1;";
        return getPersonList(quarry);

    }
    public static Person getPersonWithGivenDonnerID(int id) throws SQLException, ClassNotFoundException {
        return getPersonById(id);

    }
    public static Person getPersonWithReceivedDonnerId(int id) throws SQLException, ClassNotFoundException {


        return getPersonById(id);
    }

    private static Person getPerson(String quarry) throws SQLException, ClassNotFoundException {
        int addressId;
        int passwordId;
        int id;
        String firstName;
        String lastName;
        String phoneNumber;
        String email;
        String dateOfBirth;
        String bloodGroup;
        String gender;
        boolean readyToDonate ;
        boolean needBlood;
        Person person = null;
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            id=resultSet.getInt("id");
            bloodGroup= resultSet.getString("blood_group");
            dateOfBirth=resultSet.getString("date_of_birth");
            email = resultSet.getString("email");
            firstName=resultSet.getString("first_name");
            lastName=resultSet.getString("last_name");
            gender=resultSet.getString("gender");
            phoneNumber=resultSet.getString("phone_number");
            readyToDonate=resultSet.getBoolean("ready_to_donate");
            needBlood=resultSet.getBoolean("need_blood");
            passwordId=resultSet.getInt("password_id");
            addressId=resultSet.getInt("address_id");
             person= new  Person(addressId,passwordId,id,firstName,lastName,phoneNumber,email,dateOfBirth,bloodGroup,gender,readyToDonate,needBlood);


        }
        return person ;

    }
    private static  List<Person> getPersonList(String quarry) throws SQLException, ClassNotFoundException {
        int addressId;
        int passwordId;
        int id;
        String firstName;
        String lastName;
        String phoneNumber;
        String email;
        String dateOfBirth;
        String bloodGroup;
        String gender;
        boolean readyToDonate ;
        boolean needBlood;
        List<Person> personList = new ArrayList<>();
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            id=resultSet.getInt("id");
            bloodGroup= resultSet.getString("blood_group");
            dateOfBirth=resultSet.getString("date_of_birth");
            email = resultSet.getString("email");
            firstName=resultSet.getString("first_name");
            lastName=resultSet.getString("last_name");
            gender=resultSet.getString("gender");
            phoneNumber=resultSet.getString("phone_number");
            readyToDonate=resultSet.getBoolean("ready_to_donate");
            needBlood=resultSet.getBoolean("need_blood");
            passwordId=resultSet.getInt("password_id");
            addressId=resultSet.getInt("address_id");
            personList.add(new Person(addressId,passwordId,id,firstName,lastName,phoneNumber,email,dateOfBirth,bloodGroup,gender,readyToDonate,needBlood));


        }
        return personList;

    }

    public static boolean readyToDonateEvent(String eventName,int personId) throws SQLException, ClassNotFoundException {
        String quarry="CREATE EVENT IF NOT EXISTS "+eventName+" ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 1 MINUTE DO UPDATE person SET ready_to_donate = 1 WHERE id="+personId+";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        return preparedStatement.execute();
    }
    public static boolean setNeedBloodTrue(int id) throws SQLException, ClassNotFoundException {
        String quarry="UPDATE person SET need_blood = 1 WHERE id="+id+";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        return preparedStatement.execute();
    }
    public static boolean setReadyToDonateFalse(int id) throws SQLException, ClassNotFoundException {
        String quarry="UPDATE person SET need_blood = 0 WHERE id="+id+";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        return preparedStatement.execute();
    }

    public static String getEmailByPhoneNo(String phoneNo) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  email FROM person WHERE phone_number='"+phoneNo+"';";
        String email = "";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            email=resultSet.getString("email");
        }
        return email;
    }

}
