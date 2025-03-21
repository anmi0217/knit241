package org.knit.solutions.lab11.task25;
import org.knit.solutions.lab11.task24.DatabaseConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDAO {

    private static final String INSERT_FILE_SQL = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";
    private static final String SELECT_ALL_FILES_SQL = "SELECT id, file_name, file_binary FROM files";

    private final Connection connection;

    public FileDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveFile(File file) throws SQLException, IOException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_FILE_SQL)) {

            statement.setString(1, file.getName());

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                statement.setBytes(2, fileBytes);
            }

            statement.executeUpdate();
            System.out.println("Файл " + file.getName() + " успешно сохранен в базе данных.");
        }
    }

    public void listAllFiles() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FILES_SQL);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Содержимое таблицы files:");
            System.out.printf("%-5s %-20s %-10s%n", "ID", "Имя файла", "Размер файла");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fileName = resultSet.getString("file_name");
                byte[] fileBinary = resultSet.getBytes("file_binary");

                System.out.printf("%-5d %-20s %-10d%n", id, fileName, fileBinary.length);
            }
        }
    }
}