package org.knit.solutions.ClassesSem1.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class PathManager {
    public static void run() {

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        Path dirPath = Paths.get(projectPath, "src", "main", "java", "org", "knit", "solutions", "sem1", "lab7");

        AtomicLong allSymbols = new AtomicLong();

        try (Stream<Path> paths = Files.walk(dirPath)) {
            paths.filter(Files::isRegularFile).filter(path -> path.toString().endsWith(".txt")).forEach(path -> {
                try {
                    long wordCount = countSymbol(path);
                    allSymbols.addAndGet(wordCount);
                    System.out.println("Файл: " + path + "; Количество слов: " + wordCount);
                } catch (IOException e) {
                    System.out.println("Ошибка при обработке файла: " + path + ", " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Ошибка при обходе папки: " + e.getMessage());
        }
        System.out.println("Всего символов: " + allSymbols);
    }


    // Метод для подсчета символов в файле
    private static long countSymbol(Path filePath) throws IOException {
        long wordCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Содержимое файла: " + line);
                wordCount += line.length();
            }
        }
        return wordCount;
    }
}
