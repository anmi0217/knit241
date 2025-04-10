package org.knit.solutions.task25;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileDAO {
    private static final String query = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";

    public void saveFile(File file) throws SQLException, IOException {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, file.getName());
            try (
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
            ) {
                byte[] buffer = new byte[(int) file.length()];
                for (int length; (length = fileInputStream.read(buffer)) != -1; ) {
                    byteArrayOutputStream.write(buffer, 0, length);
                }
                statement.setBytes(2, byteArrayOutputStream.toByteArray());  // Содержимое файла в формате BYTEA
            }
            statement.executeUpdate();
        }
    }
}
