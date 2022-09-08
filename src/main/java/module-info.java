module com.mahbubalam.blooddonationsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.mail;
    requires activation;


    opens com.mahbubalam.blooddonationsystem to javafx.fxml;
    exports com.mahbubalam.blooddonationsystem;
}