package org.knit.tasks.task19;

public class Task19 {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(findMax(numbers));

        String[] words = {"apple", "banana", "cherry"};
        System.out.println(findMax(words));
    }

    private static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = array[i].compareTo(max) > 0 ? array[i] : max;
        }
        return max;
    }
}
