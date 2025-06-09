//12
package org.knit.solutions.org.lab7;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Practica {
    static int totalWordCount = 0;

    public static void main(String[] args) {
        Path startPath = Paths.get("/Users/anastasiaholodova/Documents/Java");
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor());
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }
        System.out.println("\nВо всех файлах с расширением '.txt' " + totalWordCount + " слов");
    }

    // Реализация FileVisitor для обхода файловой системы
    private static class SimpleFileVisitor extends java.nio.file.SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println("\nКаталог: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

            if (file.toString().endsWith(".txt")) {
                try {
                    int wordCount = countWordsInFile(file);
                    totalWordCount += wordCount;
                    System.out.println("Файл: " + file + " содержит " + wordCount + " слов.");
                    return FileVisitResult.CONTINUE;
                } catch (IOException e) {
                    System.out.println("Ошибка при чтении файла: " + file + " - " + e.getMessage());
                }
            } else {
                System.out.println("Файл: " + file.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        private int countWordsInFile(Path file) throws IOException {
            String content = new String(Files.readAllBytes(file));
            if (content.trim().isEmpty()) {
                return 0;
            }
            String[] words = content.split("\\s+");
            return words.length;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Ошибка доступа к файлу: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            System.out.println("Завершение каталога: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}
