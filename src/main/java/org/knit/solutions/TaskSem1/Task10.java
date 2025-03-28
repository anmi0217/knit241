package org.knit.solutions.TaskSem1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача №10: Консольная игра "Виселица"
 * <p>
 * Описание:
 * 1. Программа выбирает случайное слово из списка.
 * 2. Игроку показываются неугаданные буквы как "_".
 * 3. Игрок вводит букву. Если буква есть в слове, она открывается.
 * 4. Если буквы нет — количество попыток уменьшается.
 * 5. Игра завершается победой (если слово отгадано) или поражением (если попытки закончились).
 * <p>
 * Требования:
 * - Использовать List или Set для хранения слов.
 * - Использовать Set для отслеживания угаданных букв.
 * - Количество попыток — 6.
 */


@TaskDescription(taskNumber = 10,
        taskDescription = "Консольная игра \"Виселица\"",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task10 implements Solution {
    public void execute() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        List<String> words = getWords();

        char[] randomWord = words.get(random.nextInt(words.size())).toCharArray();
        //System.out.println(randomWord);
        boolean[] indexWord = new boolean[randomWord.length];
        int attemptsLeft = 6;  // Количество попыток
        boolean wordGuessed = false;
        Set<Character> currentSymbol = new HashSet<>(); // храение уже введённых буквы

        System.out.println("Игра Виселица!");
        System.out.println("Угадайте слово. У вас есть " + attemptsLeft + " попыток.");
        System.out.println(getSecretWord(randomWord, indexWord));

        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.print("Введите букву: ");
            char inputChar = scanner.next().charAt(0);

            // Проверка на повторный ввод
            if (currentSymbol.contains(inputChar)) {
                System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
                continue;
            }

            currentSymbol.add(inputChar);

            // Проверка наличия символа и обновление статуса
            if (!searchChar(inputChar, randomWord, indexWord)) {
                attemptsLeft--;
                System.out.println("Неправильно! Осталось попыток: " + attemptsLeft);
            } else {
                System.out.println("Правильно!");
            }

            // Вывод текущего состояния слова
            String secretWord = getSecretWord(randomWord, indexWord);
            System.out.println(secretWord);

            if (!secretWord.contains("_")) {
                wordGuessed = true;
            }
        }
        if (wordGuessed) {
            System.out.println("Поздравляем! Вы угадали слово: " + new String(randomWord));
        } else {
            System.out.println("Вы проиграли! Загаданное слово было: " + new String(randomWord));
        }
    }

    public static String getSecretWord(char[] word, boolean[] index) {
        char[] secretWord = new char[word.length];
        for (int i = 0; i < word.length; i++) {
            if (index[i]) {
                secretWord[i] = word[i];
            } else {
                secretWord[i] = '_';
            }
        }
        return new String(secretWord);
    }

    public static boolean searchChar(char symbol, char[] word, boolean[] index) {
        boolean found = false;
        for (int i = 0; i < word.length; i++) {
            if (symbol == word[i]) {
                index[i] = true;
                found = true;
            }
        }
        return found; // Возвращает true, если символ найден
    }

    public static List<String> getWords() {
        File file = new File("src/misc/dictionary.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл словаря не найден. Проверьте путь к файлу.");
        }
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.nextLine().trim();
            if (word.length() > 4) {
                words.add(word);
            }
        }
        scanner.close();
        return words;
    }
}
