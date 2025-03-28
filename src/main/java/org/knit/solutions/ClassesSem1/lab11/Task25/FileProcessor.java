package org.knit.solutions.ClassesSem1.lab11.Task25;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileProcessor {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB
    private final FileDAO fileDAO;

    public FileProcessor() {
        this.fileDAO = new FileDAO();
    }

    public void processFiles(String path) {
        File fileOrDirectory = new File(path);
        if (!fileOrDirectory.exists()) {
            System.out.println("Путь не существует.");
            return;
        }

        if (fileOrDirectory.isFile()) {
            saveFile(fileOrDirectory);
        } else if (fileOrDirectory.isDirectory()) {
            for (File file : fileOrDirectory.listFiles()) {
                if (file.isFile()) {
                    saveFile(file);
                }
            }
        } else {
            System.out.println("Неверный путь.");
        }

        // После обработки всех файлов выводим содержимое базы данных
        try {
            fileDAO.printAllFiles();
        } catch (SQLException e) {
            System.out.println("Ошибка при выводе содержимого базы данных: " + e.getMessage());
        }
    }

    private void saveFile(File file) {
        if (file.length() > MAX_FILE_SIZE) {
            System.out.printf("Файл %s пропущен: размер больше 10 MB.%n", file.getName());
            return;
        }

        try {
            fileDAO.saveFile(file);
            System.out.printf("Файл %s сохранён в базу данных.%n", file.getName());
        } catch (IOException | SQLException e) {
            System.out.printf("Ошибка при сохранении файла %s: %s%n", file.getName(), e.getMessage());
        }
    }
}
