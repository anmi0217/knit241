package org.knit.tasks.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryFactory {
    public static DictionaryStatistics createDictionaryStatistics(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            List<String> dictionary = new ArrayList<>();
            while (scanner.hasNext()) {
                dictionary.add(scanner.nextLine());
            }
            scanner.close();
            char[] alphabet = new char[32];
            for (int i = 0, letter = 'а'; letter <= 'я'; i++, letter++) {
                alphabet[i] = (char) letter;
            }
            return new DictionaryStatistics(dictionary.toArray(new String[0]), alphabet);
        } catch (FileNotFoundException e) {
            System.out.println("Указан неверный путь или файл не существует.");
            return null;
        }
    }
}
