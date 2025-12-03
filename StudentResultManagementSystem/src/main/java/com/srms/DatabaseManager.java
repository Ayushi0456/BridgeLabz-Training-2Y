package com.srms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
        return con;
    }
}

