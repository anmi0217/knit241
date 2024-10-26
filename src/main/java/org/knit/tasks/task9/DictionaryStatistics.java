package org.knit.tasks.task9;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DictionaryStatistics {
    private final String[] dictionary;
    private final int dictionarySize;
    private final int palindromesNumber;
    private final int maxWordLength;
    private final int minWordLength;
    private final char[] alphabet;
    private final Map<Character, Integer> letterFrequency = new HashMap<>();

    public DictionaryStatistics(String[] dictionary, char[] alphabet) {
        this.dictionary = dictionary;
        this.alphabet = alphabet;

        for (char letter : alphabet) {
            letterFrequency.put(letter, 0);
        }

        int k = 0, max = 0, min = Integer.MAX_VALUE;
        for (String word : dictionary) {
            if (isPalindrome(word)) {
                k++;
            }
            max = Integer.max(word.length(), max);
            min = Integer.min(word.length(), min);
            countLetterFrequency(word);
        }

        dictionarySize = dictionary.length;
        palindromesNumber = k;
        maxWordLength = max;
        minWordLength = min;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void countLetterFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (letterFrequency.containsKey(word.charAt(i))) {
                letterFrequency.put(word.charAt(i), letterFrequency.get(word.charAt(i)) + 1);
            }
        }
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public int getPalindromesNumber() {
        return palindromesNumber;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public String getRandomWord() {
        return dictionary[new Random().nextInt(dictionarySize)];
    }

    public void printLetterStatistics() {
        for (char letter : alphabet) {
            System.out.printf("%c - %d\n", letter, letterFrequency.get(letter));
        }
    }
}
