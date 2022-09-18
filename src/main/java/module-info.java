module com.mahbubalam.blooddonationsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.mail;
    requires activation;
    requires com.jfoenix;


    opens com.mahbubalam.blooddonationsystem to javafx.fxml;
    exports com.mahbubalam.blooddonationsystem;
    exports com.mahbubalam.blooddonationsystem.singletron;
    opens com.mahbubalam.blooddonationsystem.singletron to javafx.fxml;
    exports com.mahbubalam.blooddonationsystem.server.entity;
    opens com.mahbubalam.blooddonationsystem.server.entity to javafx.fxml;
    exports com.mahbubalam.blooddonationsystem.server.model;
    opens com.mahbubalam.blooddonationsystem.server.model to javafx.fxml;
}