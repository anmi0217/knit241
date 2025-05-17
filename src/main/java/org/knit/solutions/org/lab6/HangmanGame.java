package org.knit.solutions.org.lab6;
import java.util.*;

public class HangmanGame {
    private static final List<String> words = getWords(); // Получение списка слов
    private static final int MAX_ATTEMPTS = 6; // Максимальное количество попыток
    private String chosenWord; // Загаданное слово
    private StringBuilder currentGuess; // Текущее состояние отгадываемого слова
    private Set<Character> guessedLetters; // Угаданные буквы

    private static List<String> getWords() {
        return Arrays.asList(
                "море", "компьютер", "программирование", "лимон", "игра", "виселица", "алгоритм", "доска", "код",
                "учебник");
    }

    public HangmanGame() {
        Collections.shuffle(words);
        List<String> gameWords = new ArrayList<>();

        for (String w : words) {
            if (w.length() > 4) {
                gameWords.add(w);
            }
        }

        chosenWord = gameWords.get(new Random().nextInt(gameWords.size()));
        currentGuess = new StringBuilder("_".repeat(chosenWord.length()));
        guessedLetters = new HashSet<>();
    }

    // Метод для игры
    public void play() {
        int remainingAttempts = MAX_ATTEMPTS;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру 'Виселица'!");

        while (remainingAttempts > 0 && currentGuess.toString().contains("_")) {
            System.out.println("Загаданное слово: " + currentGuess);
            System.out.println("Введите букву:");

            String input = scanner.nextLine().trim().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Пожалуйста, введите одну букву.");
                continue;
            }

            char letter = input.charAt(0);
            if (guessedLetters.contains(letter)) {
                System.out.println("Вы уже угадали букву '" + letter + "'. Попробуйте другую букву.");
                continue;
            }

            guessedLetters.add(letter);

            if (chosenWord.contains(String.valueOf(letter))) {
                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == letter) {
                        currentGuess.setCharAt(i, letter);
                    }
                }
                System.out.println("Отлично! Буква '" + letter + "' есть в слове.");
            } else {
                remainingAttempts--;
                System.out.println("Неверно! Осталось попыток: " + remainingAttempts);
            }
        }

        if (currentGuess.toString().equals(chosenWord)) {
            System.out.println("Поздравляем! Вы угадали слово: " + chosenWord);
        } else {
            System.out.println("Вы проиграли! Загаданное слово было: " + chosenWord);
        }
    }

    // Главный метод
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}