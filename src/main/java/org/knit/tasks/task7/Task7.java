package org.knit.tasks.task7;

public class Task7 {
    public static void main(String[] args) {
        DictionaryStatistics dictionaryStatistics =
                DictionaryFactory.createDictionaryStatistics("misc/dictionary.txt");
        if (dictionaryStatistics != null) {
            System.out.println("Количество слов: " + dictionaryStatistics.getDictionarySize());
            System.out.println("Количество палиндромов: " + dictionaryStatistics.getPalindromesNumber());
            System.out.println("Максимальная длина слова: " + dictionaryStatistics.getMaxWordLength());
            System.out.println("Минимальная длина слова: " + dictionaryStatistics.getMinWordLength());
            System.out.println("Случайное слово: " + dictionaryStatistics.getRandomWord());
            System.out.println("Частота букв в словаре:");
            dictionaryStatistics.printLetterStatistics();
        }
    }
}
