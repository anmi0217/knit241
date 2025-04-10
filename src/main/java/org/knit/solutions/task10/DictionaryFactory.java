package org.knit.solutions.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DictionaryFactory {
    public static Dictionary createDictionary(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            Set<Character> alphabet = new HashSet<>();
            for (int letter = 'а'; letter <= 'я'; letter++) {
                alphabet.add((char) letter);
            }
            alphabet.add('-');
            List<String> dictionary = new ArrayList<>();
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                boolean isValid = true;
                for (int i = 0; i < word.length(); i++) {
                    if (!alphabet.contains(word.charAt(i))) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
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
