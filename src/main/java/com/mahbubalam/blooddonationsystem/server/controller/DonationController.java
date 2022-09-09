package com.mahbubalam.blooddonationsystem.server.controller;

import com.mahbubalam.blooddonationsystem.server.entity.Donation;
import com.mahbubalam.blooddonationsystem.server.provider.ConnectionProvider;

import java.sql.*;

public class DonationController {
    public static int saveDonation(Donation donation) throws SQLException, ClassNotFoundException {

        int donationId = 0;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "insert  into  donation(donation_date, hospital_name, received_donner_id, given_donner_id)   values('" + donation.getDonationDate() + "','" + donation.getHospitalName() + "','" + donation.getDonatedPersonId() + "','" + donation.getReceivedPersonId() + "');";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        while (resultSet.next()) {
            donationId = resultSet.getInt(1);
        }

        return donationId;
    }


}
