package org.knit.solutions.org.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/anastasiaholodova/Documents/Java/dictionary.txt";

        // для подсчета частоты
        char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

        try {
            List<String> wordsList = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                String word = scanner.nextLine().toLowerCase();
                wordsList.add(word);
            }
            scanner.close();

            String[] words = wordsList.toArray(new String[0]);

            DictionaryStatistic dictionaryStatistic = new DictionaryStatistic(words, alphabet);

            dictionaryStatistic.getRandomWord();

            dictionaryStatistic.printSymbolsStat();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        }
    }
}