package org.knit.solutions.org.lab1725;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileProcessor {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024;

    public void processFile(String path) {
        File fileOrDirectory = new File(path);

        if (!fileOrDirectory.exists()) {
            System.out.println("Указанный путь не существует: " + path);
            return;
        }

        FileDAO fileDAO = new FileDAOImpl();

        if (fileOrDirectory.isFile()) {
            processFile(fileOrDirectory, fileDAO);
        } else if (fileOrDirectory.isDirectory()) {
            File[] files = fileOrDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        processFile(file, fileDAO);
                    }
                }
            }
        }
    }

    private void processFile(File file, FileDAO fileDAO) {
        if (file.length() > MAX_FILE_SIZE) {
            System.out.println("Файл " + file.getName() + " превышает максимальный размер и не будет сохранен.");
            return;
        }

        try {
            fileDAO.saveFile(file);
            System.out.println("Файл " + file.getName() + " успешно сохранен в базу данных.");
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка при сохранении файла " + file.getName() + ": " + e.getMessage());
        }
    }
}