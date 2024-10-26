package org.knit.tasks.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryFactory {
    public static Dictionary createDictionary(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            List<String> dictionary = new ArrayList<>();
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                if (word.length() >= 4 && word.length() <= 12) {
                    dictionary.add(word);
                }
            }
            scanner.close();
            return new Dictionary(dictionary.toArray(new String[0]));
        } catch (FileNotFoundException e) {
            System.out.println("Указан неверный путь или файл не существует.");
            return null;
        }
    }
}
