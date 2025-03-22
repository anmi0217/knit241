//21
package org.knit.solutions.org.lab10;

import java.util.*;
import java.util.function.Predicate;

public class Filter {

    // Универсальный метод фильтрации
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) { // Проверяем, удовлетворяет ли элемент предикату
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        // Пример с фильтрацией строк
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Фильтруем элементы, начинающиеся с буквы "b"
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered);
    }
}