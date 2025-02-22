package org.knit.lab11.task25;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class FileApp {

    public void execute() {
        try {
            Connection connection = DatabaseConnection.initializeDatabase();
            FileDAO fileDAO = new FileDAO(connection);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите путь к файлу или папке: ");
            String path = scanner.nextLine();

            FileProcessor processor = new FileProcessor(fileDAO);
            processor.processFiles(path);
            fileDAO.listAllFiles();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Ошибка работы с базой данных: " + e.getMessage());
        }
    }
}