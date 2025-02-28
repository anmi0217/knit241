package org.knit.lab11.task25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/assets";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS files (" +
            "id SERIAL PRIMARY KEY," +
            "file_name VARCHAR(255) NOT NULL," +
            "file_binary BYTEA NOT NULL" +
            ");";

    public static Connection initializeDatabase() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_SQL);
            System.out.println("Таблица 'files' проверена/создана.");
        }

        return connection;
    }
}
