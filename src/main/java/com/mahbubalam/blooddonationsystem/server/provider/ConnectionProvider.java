package com.mahbubalam.blooddonationsystem.server.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection connection;

    public static Connection createConnection() throws ClassNotFoundException, SQLException {

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/bloodbankdb";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);


            return connection;
    }

}
