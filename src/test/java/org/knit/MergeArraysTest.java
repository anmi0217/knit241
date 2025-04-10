package org.knit;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.knit.solutions.task43.Task43.mergeArrays;

/**
 * Проверяется метод, объединяющий два массива.
 * Изменения выполняются на месте и записываются в первый массив.
 */
public class MergeArraysTest {
    /**
     * Проверяется обычный случай с уникальными числами.
     * Первый входной массив: [1, 4, 5, 0, 0, 0].
     * Второй входной массив: [2, 3, 6].
     * Первый массив после применения метода: [1, 2, 3, 4, 5, 6].
     */
    @Test
    public void usualCase1() {
        int[] a1 = {1, 4, 5, 0, 0, 0};
        int m = 3;
        int[] a2 = {2, 3, 6};
        int n = 3;
        mergeArrays(a1, m, a2, n);
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expectedArray, a1);
    }

    /**
     * Проверяется обычный случай с дупликатами.
     * Первый входной массив: [1, 1, 2, 3, 6, 0, 0, 0].
     * Второй входной массив: [2, 4, 7].
     * Первый массив после применения метода: [1, 1, 2, 2, 3, 4, 6, 7].
     */
    @Test
    public void usualCase2() {
        int[] a1 = {1, 1, 2, 3, 6, 0, 0, 0};
        int m = 5;
        int[] a2 = {2, 4, 5};
        int n = 3;
        mergeArrays(a1, m, a2, n);
        int[] expectedArray = {1, 1, 2, 2, 3, 4, 5, 6};
        assertArrayEquals(expectedArray, a1);
    }

    /**
     * Проверяется обычный случай с отрицательными числами.
     * Первый входной массив: [-3, -2, 0, 1, 4, 0, 0, 0].
     * Второй входной массив: [-2, 2, 4].
     * Первый массив после применения метода: [-3, -2, -2, 0, 1, 2, 4, 4].
     */
    @Test
    public void usualCase3() {
        int[] a1 = {-3, -2, 0, 1, 4, 0, 0, 0};
        int m = 5;
        int[] a2 = {-2, 2, 4};
        int n = 3;
        mergeArrays(a1, m, a2, n);
        int[] expectedArray = {-3, -2, -2, 0, 1, 2, 4, 4};
        assertArrayEquals(expectedArray, a1);
    }

    /**
     * Проверяется частный случай с пустым первым массивом.
     * Первый входной массив: [0, 0, 0].
     * Второй входной массив: [3, 3, 6].
     * Первый массив после применения метода: [3, 3, 6].
     */
    @Test
    public void specialCase1() {
        int[] a1 = {0, 0, 0};
        int m = 0;
        int[] a2 = {3, 3, 6};
        int n = 3;
        mergeArrays(a1, m, a2, n);
        int[] expectedArray = {3, 3, 6};
        assertArrayEquals(expectedArray, a1);
    }

    /**
     * Проверяется частный случай с пустым вторым массивом.
     * Первый входной массив: [2, 4, 6].
     * Второй входной массив: [].
     * Первый массив после применения метода: [2, 4, 6].
     */
    @Test
    public void specialCase2() {
        int[] a1 = {2, 4, 6};
        int m = 3;
        int[] a2 = {};
        int n = 0;
        mergeArrays(a1, m, a2, n);
        int[] expectedArray = {2, 4, 6};
        assertArrayEquals(expectedArray, a1);
    }

    /**
     * Проверяется частный случай с двумя пустыми массивами.
     * Первый входной массив: [].
     * Второй входной массив: [].
     * Первый массив после применения метода: [].
     */
    @Test
    public void specialCase3() {
        int[] a1 = {};
        int m = 0;
        int[] a2 = {};
        int n = 0;
        mergeArrays(a1, m, a2, n);
        int[] expectedArray = {};
        assertArrayEquals(expectedArray, a1);
    }

    /**
     * Считается время выполнения на больших массивах (10000).
     * Время выполнение не должно превышать 65 мс.
     */
    @Test
    public void calculateExecutionTime() {
        int m = 10000;
        int n = 10000;
        int[] a1 = new int[m + n];
        int[] a2 = new int[n];
        for (int i = 0; i < n; i++) {
            a2[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Arrays.sort(a2);
        System.arraycopy(a2, 0, a1, 0, n);
        for (int i = 0; i < n; i++) {
            a2[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Arrays.sort(a2);
        long start = System.currentTimeMillis();
        mergeArrays(a1, m, a2, n);
        long end = System.currentTimeMillis();
        assertTrue(end - start < 65);
    }
}
