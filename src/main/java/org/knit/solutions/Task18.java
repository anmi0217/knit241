package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task18.DuplicateZeros;

import java.util.Arrays;

/*
Условие задачи:
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
 */

@TaskDescription(taskNumber = 18, taskDescription = "Задача № 18")
public class Task18 implements Solution{
    @Override
    public void execute() {
        DuplicateZeros solution = new DuplicateZeros();
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3};
        solution.duplicateZeros(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
