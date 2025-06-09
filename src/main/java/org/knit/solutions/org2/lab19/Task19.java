package org.knit.solutions.org2.lab19;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(
        taskNumber = 19,
        taskDescription = "Объединение двух отсортированных массивов в один с сохранением порядка"
)
public class Task19 implements Solution {
    @Override
    public void execute() {
        // Тестовые данные из примеров
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        System.out.println("Пример 1:");
        System.out.println("Исходный nums1: " + arrayToString(nums1, 3));
        System.out.println("Исходный nums2: " + arrayToString(nums2, 3));

        merge(nums1, 3, nums2, 3);
        System.out.println("Результат слияния: " + arrayToString(nums1, 6));
        System.out.println();

        // Дополнительные тестовые случаи
        int[] case2nums1 = {1, 0};
        int[] case2nums2 = {};
        System.out.println("Пример 2 (пустой nums2):");
        System.out.println("Исходный nums1: " + arrayToString(case2nums1, 1));
        System.out.println("Исходный nums2: " + arrayToString(case2nums2, 0));

        merge(case2nums1, 1, case2nums2, 0);
        System.out.println("Результат слияния: " + arrayToString(case2nums1, 1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    private String arrayToString(int[] arr, int length) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}