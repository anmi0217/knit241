package org.knit.lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Task21 {
    public void execute() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry");
        List<String> filteredWords = filter(words, s -> s.startsWith("b"));
        System.out.println(filteredWords);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filter(numbers, n -> n % 3 == 0);
        System.out.println(evenNumbers);

        List<String> longWords = filter(words, s -> s.length() > 5);
        System.out.println(longWords);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
