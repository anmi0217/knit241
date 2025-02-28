package org.knit.lab10;

public class Task19 {
    public void execute() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Максимальное число: " + findMax(numbers));

        // Пример со строками
        String[] words = {"apple", "banana", "cherry"};
        System.out.println("Максимальное слово: " + findMax(words));

        // Пример с вещественными числами
        Double[] doubles = {1.1, 2.2, 3.3, 4.4};
        System.out.println("Максимальное значение: " + findMax(doubles));
    }
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым.");
        }

        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
}
