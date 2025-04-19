package org.knit.solutions.org2.lad18;

import org.junit.jupiter.api.Test;
import org.knit.solutions.org2.lab19.Task19;

import static org.junit.jupiter.api.Assertions.*;



class SolutionTest {
    private final Task19 solution = new Task19();

    @Test
    void testNormalMerge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void testEmptyNums2() {
        int[] nums1 = {1, 0};
        int[] nums2 = {};
        solution.merge(nums1, 1, nums2, 0);
        assertArrayEquals(new int[]{1, 0}, nums1);
    }

    @Test
    void testEmptyNums1() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        solution.merge(nums1, 0, nums2, 1);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-5, -2, 0, 0, 0};
        int[] nums2 = {-3, 0, 4};
        solution.merge(nums1, 2, nums2, 3);
        assertArrayEquals(new int[]{-5, -3, -2, 0, 4}, nums1);
    }

    @Test
    void testDuplicates() {
        int[] nums1 = {1, 2, 2, 0, 0};
        int[] nums2 = {2, 3};
        solution.merge(nums1, 3, nums2, 2);
        assertArrayEquals(new int[]{1, 2, 2, 2, 3}, nums1);
    }

    @Test
    void testPerformance() {
        int m = 100000;
        int n = 100000;
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        // Заполняем тестовыми данными
        for (int i = 0; i < m; i++) {
            nums1[i] = i * 2; // Четные числа: 0, 2, 4, ..., 199998
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = i * 2 + 1; // Нечетные числа: 1, 3, 5, ..., 199999
        }

        long startTime = System.currentTimeMillis();
        solution.merge(nums1, m, nums2, n);
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения для массивов размером " + m + "+" + n +
                ": " + (endTime - startTime) + " мс");

        // Проверка первого, среднего и последнего элементов
        assertEquals(0, nums1[0]); // Первый элемент должен быть 0
        assertEquals(199999, nums1[m + n - 1]); // Последний элемент должен быть 199999

        // Исправленная проверка среднего элемента
        int midIndex = (m + n) / 2;
        assertEquals(midIndex, nums1[midIndex]); // Средний элемент должен быть равен своему индексу
    }
}