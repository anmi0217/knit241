package org.knit.solutions.org.lab1725;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:/Users/anastasiaholodova/Documents/GitHub/knit241/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "sa";

    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}