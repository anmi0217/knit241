package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab4.Task7.DictionaryStatistic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


import org.knit.TaskDescription;
/***
 * Лабораторная работа №4
 *
 * Цель:
 * - Научиться работать с массивами
 * - Научиться работать со строками
 *
 * Задача №7 *
 *
 * Создайте класс DictionaryStatistic с полями:
 * - Массив слов из словаря
 * - Количество слов
 * - Количество палиндромов
 * - Максимальная и минимальная длина слова
 * - Массив алфавита
 * - Частота букв в словаре
 *
 * Реализуйте методы:
 * - getRandomWord() — получить случайное слово из словаря
 * - printSymbolsStat() — вывести частоту встречаемости букв
 *
 * Дополнительно *
 * Реализуйте игру в слова:
 * - На вход подается слово
 * - Найдите все возможные слова, составленные из его букв
 */

@TaskDescription(taskNumber = 7,
        taskDescription = "Статистика словаря",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task7 implements Solution {
    public void execute() {

        File file = new File("src/misc/dictionary.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        StringBuilder allWords = new StringBuilder();
        int countPalindrome = 0;
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            allWords.append(word).append(" ");
            if (isPalindrome(word)) {
                countPalindrome++;
            }
        }
        scanner.close();

        String[] words = allWords.toString().split(" ");
        DictionaryStatistic statistic = new DictionaryStatistic(words, countPalindrome);

        statistic.calculateStatistics();
        System.out.println(statistic.toPrint());

        // Рандомное слово
        System.out.println("Рандомное слово: " + statistic.getRandomWord()); // полиметилметакрилат

        // Какие слова можно составить
        GameWords("кухня", words);

    }

    public static boolean isPalindrome(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(s2);
    }

    public static void GameWords(String word, String[] words) {
        Map<Character, Integer> charCount = new HashMap<>(); // Map для хранения частоты букв основного слова
        for (char c : word.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        System.out.println("Слова которые можно составить для " + word + ": ");
        for (String candidate : words) {
            if (candidate.length() <= word.length()) {
                Map<Character, Integer> candidateCount = new HashMap<>(); // Map для хранения частоты букв "кандидатов"
                for (char c : candidate.toCharArray()) {
                    candidateCount.put(c, candidateCount.getOrDefault(c, 0) + 1);
                }

                boolean canForm = true;
                for (Map.Entry<Character, Integer> entry : candidateCount.entrySet()) {
                    char letter = entry.getKey();
                    int requiredCount = entry.getValue();

                    if (charCount.getOrDefault(letter, 0) < requiredCount) {
                        canForm = false;
                        break;
                    }
                }
                if (canForm) {
                    System.out.println(candidate);
                }
            }
        }
    }
}


