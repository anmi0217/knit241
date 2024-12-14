package org.knit.tasks.task21;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task21 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry");
        List<String> filteredWords = filter(words, s -> s.startsWith("b"));
        System.out.println(filteredWords);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
