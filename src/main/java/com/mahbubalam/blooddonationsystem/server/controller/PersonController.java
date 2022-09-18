package com.mahbubalam.blooddonationsystem.server.controller;

import com.mahbubalam.blooddonationsystem.server.entity.BloodGroup;
import com.mahbubalam.blooddonationsystem.server.entity.Gender;
import com.mahbubalam.blooddonationsystem.server.entity.Person;
import com.mahbubalam.blooddonationsystem.server.model.ShowPerson;
import com.mahbubalam.blooddonationsystem.server.provider.ConnectionProvider;
import com.mahbubalam.blooddonationsystem.singletron.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonController {

    public static void savePerson(String firstName, String lastName, String phoneNo, String email, String dateOfBirth, BloodGroup bloodGroup, Gender gender) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "insert  into  person(blood_group, date_of_birth, email, first_name,last_name,gender,phone_number,ready_to_donate,need_blood,address_id,password_id)   values('" + bloodGroup + "','" + dateOfBirth + "','" + email + "','" + firstName + "','" + lastName + "','" + gender + "','" + phoneNo + "',1,0,(SELECT MAX( id ) FROM address),(SELECT MAX( id ) FROM password));";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.execute();
    }
    public static void updateName(String firstName, String lastName, int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "UPDATE person SET person.first_name = '" + firstName + "',person.last_name = '" + lastName +  "' WHERE person.id='" + id + "';";
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
    public static ObservableList<ShowPerson> getPersonWhoReadyToDonate2() throws SQLException, ClassNotFoundException {
        String quarry = "SELECT id, first_name, last_name, email, blood_group, phone_number FROM person WHERE " +
                "ready_to_donate = 1;";
        return getPersonObservableList(quarry);


    }
    public static ObservableList<ShowPerson> getPersonWhoNeedBlood2() throws SQLException, ClassNotFoundException {
        String quarry = "SELECT id, first_name, last_name, email, blood_group, phone_number FROM person WHERE " +
                "need_blood = 1;";
        return getPersonObservableList(quarry);


    }

    private static ObservableList<ShowPerson> getPersonObservableList(String quarry) throws ClassNotFoundException, SQLException {
        int id;
        String name;
        String phoneNumber;
        String email;
        String bloodGroup;
        ObservableList<ShowPerson> list = FXCollections.observableArrayList();
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            id=resultSet.getInt("id");
            bloodGroup= resultSet.getString("blood_group");
            email = resultSet.getString("email");
            name=resultSet.getString("first_name") +" "+ resultSet.getString("last_name");
            phoneNumber=resultSet.getString("phone_number");
            if (id==User.getInstance().getUserId()) continue;
            list.add(new ShowPerson(id,name,email,phoneNumber,bloodGroup));

        }
        return list;
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

    public static boolean readyToDonateEvent(int personId) throws SQLException, ClassNotFoundException {
        String eventName= User.getInstance().getName().split("")[0];
        String quarry="CREATE EVENT "+eventName+" ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 2 MINUTE DO UPDATE person SET ready_to_donate = 1 WHERE id="+personId+";";
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
    public static boolean setNeedBloodFalse(int id) throws SQLException, ClassNotFoundException {
        String quarry="UPDATE person SET need_blood = 0 WHERE id="+id+";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        return preparedStatement.execute();
    }

    public static boolean setReadyToDonateFalse(int id) throws SQLException, ClassNotFoundException {
        String quarry = "UPDATE person SET ready_to_donate = 0 WHERE id=" + id + ";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        return preparedStatement.execute();
    }

    public static boolean getReadyToDonate(int id) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT ready_to_donate FROM person  WHERE id=" + id + ";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getBoolean(1);
        }
        return false;
    }
    public static String getGenderById(int id) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  gender FROM person WHERE id='" + id + "';";
        String gender = "";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            gender = resultSet.getString("gender");
        }
        return gender;

    }
    public static int getAddressId(int ida) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  address_id FROM person WHERE id='" + ida + "';";
        int id = -1;
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("address_id");
        }
        return id;

    }

    public static String getEmailByPhoneNo(String phoneNo) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  email FROM person WHERE phone_number='" + phoneNo + "';";
        String email = "";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            email = resultSet.getString("email");
        }
        return email;

    }
    static String usingRandomUUID() {

        UUID randomUUID = UUID.randomUUID();

        return randomUUID.toString().replaceAll("-", "").substring(0,6);

    }
}
