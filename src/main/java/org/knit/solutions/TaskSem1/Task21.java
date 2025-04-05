package org.knit.solutions.TaskSem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 21: Фильтрация элементов
 * <p>
 * Описание:
 * 1. Написать универсальный метод filter, который принимает список элементов и предикат (интерфейс Predicate<T>).
 * 2. Метод должен возвращать новый список, содержащий только те элементы, которые удовлетворяют предикату.
 */

@TaskDescription(taskNumber = 21,
        taskDescription = "Фильтрация элементов",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task21 implements Solution {
    public void execute() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered); // [banana]

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}