package org.knit.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task7 {
    public void execute() throws FileNotFoundException {
        int c = 0;
        Scanner scanner = new Scanner(new File("data/dictionary.txt"));
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            c++;
        }
        scanner.close();

        Scanner scanner2 = new Scanner(new File("data/dictionary.txt"));
        int ind = 0;
        String[] words = new String[c];

        while (scanner2.hasNext()) {
            words[ind++] = scanner2.nextLine().toLowerCase();
        }
        scanner2.close();

        char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        DictionaryStatistic dictStat = new DictionaryStatistic(words, alphabet);
        System.out.println(dictStat);

        System.out.println("Случайное слово из словаря: " + dictStat.getRandomWord());

        dictStat.printSymbolsStat();
    }
}
