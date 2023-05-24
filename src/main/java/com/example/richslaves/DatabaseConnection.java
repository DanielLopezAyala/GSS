package com.example.richslaves;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = " ";
        String databaseUser = " ";
        String databaPassword = " ";
        String url = "jdbc:mysql//localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databaPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}
