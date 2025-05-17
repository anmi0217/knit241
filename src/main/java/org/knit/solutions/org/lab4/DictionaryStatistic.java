package org.knit.solutions.org.lab4;

import java.util.Random;

class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // Максимальная длина слова в словаре
    private int minWordLength; // Минимальная длина слова в словаре
    private char[] alphabet; // Буквы алфавита
    private int[] frequency; // Частота букв в словаре

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.frequency = new int[alphabet.length];
        this.dictionarySize = words.length;

        analyzeDictionary();
    }

    // Анализ словаря
    private void analyzeDictionary() {
        maxWordLength = Integer.MIN_VALUE;
        minWordLength = Integer.MAX_VALUE;
        polindrom = 0;

        for (String word : words) {
            if (isPalindrome(word)) {
                polindrom++;
            }
            maxWordLength = Math.max(maxWordLength, word.length());
            minWordLength = Math.min(minWordLength, word.length());

            countLetterFrequency(word);
        }
        System.out.println("Общее количество слов в словаре: " + dictionarySize);
        System.out.println("Максимальная длина слова в словаре: " + maxWordLength + " буквы");
        System.out.println("Минимальная длина слова в словаре: " + minWordLength + " буква");
        System.out.println("Общее количество слов палиндромов в словаре: " + polindrom);
    }

    //полиндромом
    private boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }


    // Подсчет частоты каждой буквы
    private void countLetterFrequency(String word) {
        for (char ch : word.toCharArray()) {
            for (int i = 0; i < alphabet.length; i++) {
                if (ch == alphabet[i]) {
                    frequency[i]++;
                }
            }
        }
    }

    // Получить случайное слово из словаря
    public String getRandomWord() {
        Random random = new Random();
        //return words[random.nextInt(words.length)];

        if (isPalindrome(words[random.nextInt(words.length)])) {
            System.out.println("Случайное слово: " + words[random.nextInt(words.length)] + " - это полиндром " );
        }
        else {
            System.out.println("Случайное слово: " + words[random.nextInt(words.length)] + " - это не полиндром " );
        }
        return words[random.nextInt(words.length)];
    }

    // Вывод статистики по частоте букв
    public void printSymbolsStat() {
        System.out.println("Частота встречаемости букв:");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " - " + frequency[i]);
        }
    }
}