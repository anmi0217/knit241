package org.knit.tasks.task9;

import java.util.Scanner;

public class Task9 {
    public static final long TIMEOUT = 60000;

    public static void main(String[] args) {
        Dictionary dictionary = DictionaryFactory.createDictionary("misc/dictionary.txt");
        if (dictionary != null) {
            Scanner scanner = new Scanner(System.in);
            int enteredWordsCount = 0;
            int enteredSymbolsCount = 0;
            int correctlyEnteredWordsCount = 0;
            long startTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTimeMillis < TIMEOUT) {
                String randomWord = dictionary.getRandomWord();
                System.out.printf("\nВведите слово: %s\n", randomWord);
                String enteredWord = scanner.nextLine();
                if (System.currentTimeMillis() - startTimeMillis < TIMEOUT) {
                    enteredWordsCount++;
                    enteredSymbolsCount += enteredWord.length();
                    if (enteredWord.equals(randomWord)) {
                        correctlyEnteredWordsCount++;
                    }
                }
            }
            System.out.printf("\nВсего предложено слов: %d\n", enteredWordsCount);
            System.out.printf("Правильно введенных слов: %d\n", correctlyEnteredWordsCount);
            System.out.printf("Всего введено символов: %d\n", enteredSymbolsCount);
            System.out.printf("Скорость печати: %d сим/сек", enteredSymbolsCount / 60);
        }
    }
}
