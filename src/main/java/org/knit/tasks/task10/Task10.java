package org.knit.tasks.task10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task10 {
    public static void main(String[] args) {
        Dictionary dictionary = DictionaryFactory.createDictionary("misc/dictionary.txt");
        if (dictionary != null) {
            Scanner scanner = new Scanner(System.in);

            int attempts = 6;
            String riddleWord = dictionary.getRandomWord();
            System.out.println(riddleWord);

            Set<String> guessedLetters = new HashSet<>();
            StringBuilder printWord = new StringBuilder();

            Set<String> alphabet = new HashSet<>();
            for (int i = 0, letter = 'а'; letter <= 'я'; i++, letter++) {
                alphabet.add(String.valueOf((char) letter));
            }

            while (attempts > 0) {
                for (int i = 0; i < riddleWord.length(); i++) {
                    if (guessedLetters.contains(riddleWord.charAt(i))) {
                        printWord.append(riddleWord.charAt(i));
                    } else {
                        printWord.append('_');
                    }
                    printWord.append(' ');
                }
                System.out.printf("Загаданное слово: %s\nВведите букву: ", printWord);
                printWord.setLength(0);

                String letter = scanner.nextLine();
                if (!alphabet.contains(letter)) {
                    System.out.println("Ошибка: введена не буква");
                }
            }
        }
    }
}
