package org.knit.lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameWords {

    public void execute() {
        Set<String> dictionary = loadDictionary("data/dictionary.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово:");
        String inputWord = scanner.nextLine().toLowerCase();

        List<String> results = findWords(inputWord, dictionary);

        System.out.println("\nСлова, которые можно составить из \"" + inputWord + "\":");

        for (String i : results)
            System.out.println(i);

        System.out.println("\nВсего найдено: " + results.size());
    }


    public static Set<String> loadDictionary(String filePath) {
        Set<String> dictionary = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                dictionary.add(word.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла словаря: " + e.getMessage());
        }
        return dictionary;
    }


    public static List<String> findWords(String inputWord, Set<String> dictionary) {
        List<String> result = new ArrayList<>();
        char[] inputLetters = inputWord.toCharArray();
        Arrays.sort(inputLetters);

        for (String word : dictionary) {
            if (canFormWord(word, inputLetters)) {
                result.add(word);
            }
        }
        return result;
    }


    public static boolean canFormWord(String word, char[] inputLetters) {
        char[] wordLetters = word.toCharArray();
        Arrays.sort(wordLetters);

        int i = 0, j = 0;
        while (i < inputLetters.length && j < wordLetters.length) {
            if (inputLetters[i] == wordLetters[j]) {
                j++;
            }
            i++;
        }
        return j == wordLetters.length;
    }
}