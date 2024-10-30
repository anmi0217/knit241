package org.knit.tasks.task10;

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
            System.out.printf("Отгадайте слово из %d букв.\n", riddleWord.length());
            System.out.println("Вы можете не отгадать букву не более 6 раз.");
            Set<Character> riddleLetters = new HashSet<>();
            for (int i = 0; i < riddleWord.length(); i++) {
                riddleLetters.add(riddleWord.charAt(i));
            }
            Set<Character> guessedLetters = new HashSet<>();
            StringBuilder printWord = new StringBuilder();

            Set<String> alphabet = new HashSet<>();
            for (int i = 0, letter = 'а'; letter <= 'я'; i++, letter++) {
                alphabet.add(String.valueOf((char) letter));
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
                if (!alphabet.contains(line)) {
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
