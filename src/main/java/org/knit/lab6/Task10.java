package org.knit.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task10 {
    static final int WL = 4;
    public static void execute() {

        List<String> dictionary = loadWords("data/dictionary.txt", WL);

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру 'Виселица'!");

        boolean playAgain;

        do {
            String word = dictionary.get(random.nextInt(dictionary.size()));
            System.out.println(word);
            List<Character> currentWord = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                currentWord.add('_');
            }

            Set<Character> guessedLetters = new HashSet<>();
            int remainingAttempts = 6;

            System.out.println("Игра началась! Попробуйте угадать слово.");
            System.out.println("Загаданное слово: " + getWordDisplay(currentWord));


            // Игра
            while (remainingAttempts > 0 && currentWord.contains('_')) {
                System.out.print("Введите букву: ");
                char guessedLetter = scanner.next().toLowerCase().charAt(0);

                if (guessedLetters.contains(guessedLetter)) {
                    System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
                    continue;
                }

                guessedLetters.add(guessedLetter);

                if (word.indexOf(guessedLetter) >= 0) {
                    System.out.println("Верно!");
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guessedLetter) {
                            currentWord.set(i, guessedLetter);
                        }
                    }
                } else {
                    remainingAttempts--;
                    System.out.println("Неверно! Осталось попыток: " + remainingAttempts);
                }
                System.out.println("Загаданное слово: " + getWordDisplay(currentWord));
            }

            if (!currentWord.contains('_')) {
                System.out.println("Поздравляем! Вы угадали слово: " + word);
            } else {
                System.out.println("Вы проиграли! Загаданное слово было: " + word);
            }

            System.out.print("Хотите сыграть еще раз? (да/нет): ");
            playAgain = scanner.next().equalsIgnoreCase("да");

        } while (playAgain);

        System.out.println("Спасибо за игру!");
    }

    private static List<String> loadWords(String filePath, int wordLength) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String word = scanner.nextLine().toLowerCase();
                if (word.length() == wordLength) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден: " + filePath);
        }
        return words;
    }

    private static String getWordDisplay(List<Character> currentWord) {
        StringBuilder display = new StringBuilder();
        for (char c : currentWord) {
            display.append(c).append(' ');
        }
        return display.toString().trim();
    }
}