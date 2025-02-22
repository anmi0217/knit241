package org.knit.lab11.task24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/assets";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";
    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            createTableIfNotExists(connection);
        }
        return connection;
    }

    private static void createTableIfNotExists(Connection connection) throws SQLException {
        String createTableSql =
                "CREATE TABLE IF NOT EXISTS users (" +
                        "id SERIAL PRIMARY KEY, " +
                        "name VARCHAR(100) NOT NULL, " +
                        "email VARCHAR(100) NOT NULL UNIQUE" +
                        ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(createTableSql);
            System.out.println("Таблица \"users\" проверена/создана.");
        }

        String checkDataSql = "SELECT 1 FROM users LIMIT 1";
        try (Statement stmt = connection.createStatement();
             var rs = stmt.executeQuery(checkDataSql)) {
            if (!rs.next()) {
                String insertDataSql =
                        "INSERT INTO users (name, email) VALUES " +
                                "('John Doe', 'john.doe@example.com'), " +
                                "('Jane Smith', 'jane.smith@example.com'), " +
                                "('Alice Johnson', 'alice.johnson@example.com'), " +
                                "('Bob Brown', 'bob.brown@example.com'), " +
                                "('Charlie White', 'charlie.white@example.com');";
                stmt.executeUpdate(insertDataSql);
                System.out.println("Вставлены тестовые данные в таблицу \"users\".");
            }
        }
    }
}
