package org.knit.solutions.org2.lad18;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

/*
Дан массив целых чисел arr фиксированной длины. Необходимо продублировать каждое вхождение нуля, сдвигая остальные элементы вправо.
Примечание:
Элементы, выходящие за пределы исходного массива, не записываются.
Изменения нужно выполнить на месте (in-place), не возвращая новый массив.

Пример 1:
Вход: arr = [1,0,2,3,0,4,5,0]
Выход: [1,0,0,2,3,0,0,4]
Объяснение:
Ноль после 1 дублируется → [1,0,0,2,3,0,4,5]
Ноль после 3 дублируется → [1,0,0,2,3,0,0,4] (последний 0 выходит за границы и отбрасывается)

Пример 2:
Вход: arr = [1,2,3]
Выход: [1,2,3]
Объяснение: В массиве нет нулей, поэтому он остаётся без изменений.

Ограничения:
1 <= arr.length <= 10^4
0 <= arr[i] <= 9

Напишите решение, а затем Напишите JUnit тесты для проверки решения
Тесты должны покрывать
--Обычные случаи (с нулями и без).
--Краевые случаи (пустые массивы, все нули, нули на границах).
--Производительность (большие массивы).
 */

@TaskDescription(taskNumber = 18, taskDescription = "Продублировать каждое вхождение нуля, сдвигая остальные элементы вправо")
public class Task18 implements Solution {

    public void execute() {
        System.out.println("Задача 18 запущена");
        org.knit.solutions.Task18.Solution solution = new org.knit.solutions.Task18.Solution();

        // Пример 1
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        System.out.println("Исходный массив: " + java.util.Arrays.toString(arr1));
        solution.duplicateZeros(arr1);
        System.out.println("Массив после дублирования нулей: " + java.util.Arrays.toString(arr1));

        // Пример 2
        int[] arr2 = {1, 2, 3};
        System.out.println("\nИсходный массив: " + java.util.Arrays.toString(arr2));
        solution.duplicateZeros(arr2);
        System.out.println("Массив после дублирования нулей: " + java.util.Arrays.toString(arr2));

        // Пример 3: Пустой массив
        int[] emptyArray = {};
        System.out.println("\nИсходный массив: " + java.util.Arrays.toString(emptyArray));
        solution.duplicateZeros(emptyArray);
        System.out.println("Массив после дублирования нулей: " + java.util.Arrays.toString(emptyArray));

        // Пример 4: Все нули
        int[] allZeros = {0, 0, 0};
        System.out.println("\nИсходный массив: " + java.util.Arrays.toString(allZeros));
        solution.duplicateZeros(allZeros);
        System.out.println("Массив после дублирования нулей: " + java.util.Arrays.toString(allZeros));

        // Пример 5: Нули на границах
        int[] zeroAtEdge = {0, 1, 2, 3, 0};
        System.out.println("\nИсходный массив: " + java.util.Arrays.toString(zeroAtEdge));
        solution.duplicateZeros(zeroAtEdge);
        System.out.println("Массив после дублирования нулей: " + java.util.Arrays.toString(zeroAtEdge));

        // Тест производительности
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i % 2 == 0 ? 0 : 1; // Чередуем нули и единицы
        }
        long startTime = System.currentTimeMillis();
        solution.duplicateZeros(largeArray);
        long endTime = System.currentTimeMillis();
        System.out.println("\nВремя выполнения для большого массива: " + (endTime - startTime) + " мс");
    }
}