package org.knit.solutions;

/*
Условие задачи:
Даны два целочисленных массива nums1 и nums2, отсортированных в неубывающем порядке, а также два целых числа m и n, представляющих количество элементов в nums1 и nums2 соответственно.

Требуется:
Объединить nums1 и nums2 в один массив, отсортированный в неубывающем порядке.

Важные условия:

Итоговый отсортированный массив должен быть сохранён внутри массива nums1 (функция не должна ничего возвращать).
Массив nums1 имеет длину m + n, где:
Первые m элементов — значимые (их нужно объединять с nums2).
Последние n элементов заполнены нулями и должны быть проигнорированы.
Длина nums2 равна n.
Пример 1:
Входные данные:
nums1 = [1, 2, 3, 0, 0, 0], m = 3
nums2 = [2, 5, 6], n = 3

Результат:
[1, 2, 2, 3, 5, 6]

Объяснение:
Объединяемые массивы: [1, 2, 3] и [2, 5, 6].
Результат — [1, 2, 2, 3, 5, 6] (подчёркнутые элементы взяты из nums1).

Пример 2:
Входные данные:
nums1 = [1], m = 1
nums2 = [], n = 0

Результат:
[1]

Объяснение:
Объединяемые массивы: [1] и [].
Результат — [1].

Пример 3:
Входные данные:
nums1 = [0], m = 0
nums2 = [1], n = 1

Результат:
[1]

Объяснение:
Объединяемые массивы: [] и [1].
Поскольку m = 0, в nums1 нет значимых элементов (нули служат только для резерва места).

Ограничения:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9
Примечания:
Нельзя использовать дополнительную память для создания нового массива (кроме временных переменных).
Решение должно работать за линейное время O(m + n).
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }
}
 */

import org.knit.TaskDescription;
import org.knit.solutions.task19.MergeTwoArrays;

import java.util.Arrays;

@TaskDescription(taskNumber = 19, taskDescription = "Задание 19")
public class Task19 implements Solution{
    @Override
    public void execute() {
        MergeTwoArrays mergeTwoArrays = new MergeTwoArrays();
        int[] arr1_1 = {1, 2, 3, 0, 0, 0};
        int[] arr2_1 = {2, 5, 6};
        mergeTwoArrays.merge(arr1_1, 3, arr2_1, 3);
        System.out.println(Arrays.toString(arr1_1));

        int[] arr1_2 = {1};
        int[] arr2_2 = {};
        mergeTwoArrays.merge(arr1_2, 1, arr2_2, 0);
        System.out.println(Arrays.toString(arr1_2));

        int[] arr1_3 = {0};
        int[] arr2_3 = {1};
        mergeTwoArrays.merge(arr1_3, 0, arr2_3, 1);
        System.out.println(Arrays.toString(arr1_3));
    }
}
