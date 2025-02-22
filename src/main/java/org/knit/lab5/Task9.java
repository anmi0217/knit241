package org.knit.lab5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task9 {
    static final int END_TIME = 20_000;

    public static void execute() throws IOException {
        // Получение списка слов из файла
        List<String> words = getWords("data/dictionary.txt");
        if (words.isEmpty()) {
            System.out.println("Список слов пуст. Проверьте файл dictionary.txt.");
            return;
        }

        System.out.println("Игра началась! Вводите слова, соответствующие предложенным.");
        System.out.println("У вас есть 1 минута!");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalWords = 0;
        int correctWords = 0;
        int totalCharacters = 0;


        long startTime = System.currentTimeMillis();
        long endTime = startTime + END_TIME;

        while (System.currentTimeMillis() < endTime) {
            String randomWord = words.get(random.nextInt(words.size()));
            System.out.println("Введите слово: " + randomWord);

            String userInput = scanner.nextLine();
            totalCharacters += userInput.length();
            totalWords++;

            if (userInput.equals(randomWord)) {
                correctWords++;
            }
        }

        System.out.println("\nВремя истекло!");
        System.out.println("Итоги игры:");
        System.out.println("==================================================================");
        System.out.println("Всего предложено слов: " + totalWords);
        System.out.println("Количество правильных слов: " + correctWords);
        System.out.println("Всего введено символов: " + totalCharacters);

        double speed = totalCharacters / 60.0;
        System.out.printf("Скорость ввода: %.2f символов в секунду%n", speed);
        System.out.println("==================================================================");
    }

    // Возвращает список слов из файла
    public static List<String> getWords(String path) throws IOException {
        List<String> words = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Файл не найден: " + path);
            return words;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().trim());
            }
        }
        return words;
    }
}