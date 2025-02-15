package org.knit.tasks.task25;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        SimpleFileVisitor simpleFileVisitor = new SimpleFileVisitor();
        Files.walkFileTree(Paths.get(scanner.nextLine()), simpleFileVisitor);
    }
}
