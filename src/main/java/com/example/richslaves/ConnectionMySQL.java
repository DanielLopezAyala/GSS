package com.example.richslaves;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/GroceryStoreDataBase";
    private static final String USER = "root";
    //private static final String PASSWORD = "Finndavid4768";
    //Daniel lopez ayala
    private static final String PASSWORD = "k0k0ry1211<";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
