package com.exercise.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/userschema";
    private static final String USER = "root";
    private static final String PASSWORD = "Emil1234";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
