//19
package org.knit.solutions.org.lab10;

public class GenericFindMax {

    // Универсальный метод для поиска максимального элемента
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть null или пустым");
        }

        T max = array[0];

        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Пример с массивом чисел
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Максимальное значение в числах: " + findMax(numbers));

        // Пример с массивом строк
        String[] words = {"яблоко", "банан", "вишня"};
        System.out.println("Максимальное значение в строках: " + findMax(words));

        // Пример с массивом символов
        Character[] chars = {'а', 'я', 'е', 'б'};
        System.out.println("Максимальное значение в символах: " + findMax(chars));
    }
}