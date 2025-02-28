package org.knit.lab4;

import java.util.Random;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int palindrome; // Количество слов палиндромов
    private int maxWordLength; // Максимальная длина слова в словаре
    private int minWordLength; // Минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; // частота букв в словаре (в каждой ячейке хранит частоту букв, а индекс - это позиция буквы в alphabet)
    

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.dictionarySize = words.length;
        this.alphabet = alphabet;
        this.frequency = new int[alphabet.length];
        calculateStatistics();
    }

    private void calculateStatistics() {
        minWordLength = Integer.MAX_VALUE;
        maxWordLength = 0;
        palindrome = 0;

        for (String word : words) {
            int length = word.length();

            if (length > maxWordLength) maxWordLength = length;
            if (length < minWordLength) minWordLength = length;

            if (isPalindrome(word)) palindrome++;

            updateFrequency(word);
        }
    }

    private boolean isPalindrome(String word) {
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    private void updateFrequency(String word) {
        for (char ch : word.toCharArray()) {
            int index = getAlphabetIndex(ch);
            if (index != -1) {
                frequency[index]++;
            }
        }
    }

    private int getAlphabetIndex(char ch) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == ch) return i;
        }
        return -1;
    }

    public String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(dictionarySize);
        return words[index];
    }

    public void printSymbolsStat() {
        System.out.println("Статистика встречающихся букв:");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " - " + frequency[i]);
        }
    }

    @Override
    public String toString() {
        return "Статистика из словарика:\n" +
                "Общее количество слов: " + dictionarySize + "\n" +
                "Количество палиндромов: " + palindrome + "\n" +
                "Максимальная длина слова: " + maxWordLength + "\n" +
                "Минимальная длина слова: " + minWordLength + "\n";
    }

}