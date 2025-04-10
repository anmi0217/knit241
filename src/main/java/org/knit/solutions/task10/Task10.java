package org.knit.solutions.task10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task10 {
    public static void main(String[] args) {
        Dictionary dictionary = DictionaryFactory.createDictionary("misc/dictionary.txt");
        if (dictionary != null) {
            Scanner scanner = new Scanner(System.in);

            int mistakes = 0, attempts = 0;
            String riddleWord = dictionary.getRandomWord();
            int riddleWordLength = 0;
            for (int i = 0; i < riddleWord.length(); i++) {
                if (riddleWord.charAt(i) != '-') {
                    riddleWordLength++;
                }
            }
            System.out.printf("Отгадайте слово из %d букв.\n", riddleWordLength);
            System.out.println("Вы можете не отгадать букву не более 6 раз.");

            Set<Character> riddleLetters = new HashSet<>();
            for (int i = 0; i < riddleWord.length(); i++) {
                riddleLetters.add(riddleWord.charAt(i));
            }
            Set<Character> guessedLetters = new HashSet<>();
            if (riddleLetters.contains('-')) {
                guessedLetters.add('-');
            }
            StringBuilder printWord = new StringBuilder();

            Set<Character> alphabet = new HashSet<>();
            for (int letter = 'а'; letter <= 'я'; letter++) {
                alphabet.add((char) letter);
            }

            while (mistakes <= 6 && !guessedLetters.containsAll(riddleLetters)) {
                for (int i = 0; i < riddleWord.length(); i++) {
                    if (guessedLetters.contains(riddleWord.charAt(i))) {
                        printWord.append(riddleWord.charAt(i));
                    } else {
                        printWord.append('_');
                    }
                    printWord.append(' ');
                }
                System.out.printf("\nЗагаданное слово: %s\nВведите букву: ", printWord);
                printWord.setLength(0);

                String line = scanner.nextLine();
                if (line.length() != 1 || !alphabet.contains(line.charAt(0))) {
                    System.out.println("Ошибка: введена не буква");
                } else {
                    char letter = line.charAt(0);
                    if (guessedLetters.contains(letter)) {
                        System.out.println("Ошибка: буква уже отгадана");
                    } else if (!riddleLetters.contains(letter)) {
                        mistakes++;
                        attempts++;
                        System.out.printf("В слове нет такой буквы. Ошибок: %d\n", mistakes);
                    } else {
                        guessedLetters.add(letter);
                        attempts++;
                    }
                }
            }

            if (mistakes > 6) {
                System.out.printf("\nВы проиграли. Было загадано слово: %s\n", riddleWord);
            } else {
                System.out.printf("\nВы выиграли! Вы отгадали слово '%s' за %d попыток\n", riddleWord, attempts);
            }
        }
    }
}
