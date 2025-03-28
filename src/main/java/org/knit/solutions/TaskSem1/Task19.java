package org.knit.solutions.TaskSem1;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 19: Универсальный метод поиска максимального элемента
 * <p>
 * Описание:
 * 1. Создать универсальный метод findMax, который принимает массив элементов, реализующих интерфейс Comparable.
 * 2. Метод должен возвращать максимальный элемент из массива.
 */

@TaskDescription(taskNumber = 19,
        taskDescription = "Универсальный метод поиска максимального элемента",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task19 implements Solution {
    public void execute() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(findMax(numbers)); // 5

        String[] words = {"apple", "banana", "cherry"};
        System.out.println(findMax(words)); // cherry

        String[] a = {};
        System.out.println(findMax(a)); // cherry
    }

    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array.length > 0) {
            T max = array[0];
            for (T element : array) {
                if (element.compareTo(max) > 0) {
                    max = element;
                }
            }
            return max;
        } else {
            System.out.println("Массив пустой!");
            return null;
        }
    }
}
