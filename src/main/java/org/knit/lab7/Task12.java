package org.knit.lab7;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Task12 {
    public void execute() {

        Scanner fold_scan = new Scanner(System.in);
        Path startDir = Paths.get(fold_scan.nextLine());
        System.out.println("Путь к файлу: " + startDir.toAbsolutePath());
        try {
            WordCounterVisitor visitor = new WordCounterVisitor();
            Files.walkFileTree(startDir, visitor);
            System.out.println("Общее количество слов во всех текстовых файлах: " + visitor.getTotalWordCount());
        } catch (IOException e) {
            System.out.println("Ошибка при обработке директории: " + e.getMessage());
        }
    }
}

class WordCounterVisitor extends SimpleFileVisitor<Path> {
    private long totalWordCount = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        // Проверяем, является ли файл текстовым (.txt)
        if (file.toString().endsWith(".txt")) {
            System.out.println("\n" + file);
            try {
                long wordCount = countWordsInFile(file);
                totalWordCount += wordCount;
                System.out.println("Количество слов в файле: " + wordCount + "\n");
            } catch (IOException e) {
                System.out.println("Ошибка при обработке файла: " + file + " (" + e.getMessage() + ")");
            }
        }
        return FileVisitResult.CONTINUE;
    }

    private long countWordsInFile(Path filePath) throws IOException {
        long wordCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // регулярка
                wordCount += words.length;
            }
        }

        return wordCount;
    }

    public long getTotalWordCount() {
        return totalWordCount;
    }
}