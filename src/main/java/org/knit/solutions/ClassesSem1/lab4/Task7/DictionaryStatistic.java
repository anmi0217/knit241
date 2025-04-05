package org.knit.solutions.ClassesSem1.lab4.Task7;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class DictionaryStatistic {
    Random random = new Random();
    private String[] words;
    private int dictionarySize;
    private int palindromeCount;
    private int maxWordLength;
    private int minWordLength;
    private char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    private Map<Character, Integer> frequency; // Map для хранения частоты букв

    public DictionaryStatistic(String[] words, int palindromeCount) {
        this.words = words;
        this.palindromeCount = palindromeCount;
        this.dictionarySize = words.length;
        this.frequency = new TreeMap<>(); // Инициализация пустого Map
        this.maxWordLength = 0;
        this.minWordLength = Integer.MAX_VALUE;
    }

    // Метод для вычисления статистик
    public void calculateStatistics() {
        for (String word : words) {
            int wordLength = word.length();

            if (wordLength > maxWordLength) maxWordLength = wordLength;
            if (wordLength < minWordLength) minWordLength = wordLength;

            for (char c : word.toLowerCase().toCharArray()) {
                if (Character.isLetter(c) && Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) { // без проверки не правильно работает
                    frequency.put(c, frequency.getOrDefault(c, 0) + 1);
                }
            }
        }
    }

    public String toPrint() {
        return "Всего слоа: " + dictionarySize + "\n" +
                "Слов \"палиндром\": " + palindromeCount + "\n" +
                "Маскимальная длина слова: " + maxWordLength + "\n" +
                "Минимальная длина слова: " + minWordLength + "\n" +
                "Частота букв: " + frequency;
    }

    public String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}
