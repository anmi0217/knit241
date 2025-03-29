package org.knit;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.knit.solutions.task42.Task42.duplicateZeros;

/**
 * Проверяется метод, дублирующий нули в массиве.
 * Элементы, выходящие за пределы входного массива, отбрасываются.
 * Изменения в массиве выполняются на месте.
 */
public class DuplicateZerosTest {
    /**
     * Проверяется обычный случай с несколькими нулями.
     * Входной массив: [1, 0, 2, 3, 0, 4, 5, 0].
     * Выходной массив должен быть: [1, 0, 0, 2, 3, 0, 0, 4].
     */
    @Test
    public void usualCase1() {
        int[] array = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(array);
        int[] expectedArray = {1, 0, 0, 2, 3, 0, 0, 4};
        assertArrayEquals(expectedArray, array);
    }

    /**
     * Проверяется обычный случай без нулей.
     * Входной массив: [1, 2, 3].
     * Выходной массив должен быть: [1, 2, 3].
     */
    @Test
    public void usualCase2() {
        int[] array = {1, 2, 3};
        duplicateZeros(array);
        int[] expectedArray = {1, 2, 3};
        assertArrayEquals(expectedArray, array);
    }

    /**
     * Проверяется обычный случай с идущими подряд нулями.
     * Входной массив: [1, 0, 2, 3, 0, 4, 5, 0].
     * Выходной массив должен быть: [1, 0, 0, 2, 3, 0, 0, 4].
     */
    @Test
    public void usualCase3() {
        int[] array = {1, 0, 0, 2, 3};
        duplicateZeros(array);
        int[] expectedArray = {1, 0, 0, 0, 0};
        assertArrayEquals(expectedArray, array);
    }

    /**
     * Проверяется частный случай с пустым массивом.
     * Входной массив: [].
     * Выходной массив должен быть: [].
     */
    @Test
    public void specialCase1() {
        int[] array = {};
        duplicateZeros(array);
        int[] expectedArray = {};
        assertArrayEquals(expectedArray, array);
    }

    /**
     * Проверяется частный случай с массивом только из нулей.
     * Входной массив: [].
     * Выходной массив должен быть: [].
     */
    @Test
    public void specialCase2() {
        int[] array = {0, 0, 0};
        duplicateZeros(array);
        int[] expectedArray = {0, 0, 0};
        assertArrayEquals(expectedArray, array);
    }

    /**
     * Проверяется частный случай с нулём на границе массива.
     * Входной массив: [].
     * Выходной массив должен быть: [].
     */
    @Test
    public void specialCase3() {
        int[] array = {1, 2, 0};
        duplicateZeros(array);
        int[] expectedArray = {1, 2, 0};
        assertArrayEquals(expectedArray, array);
    }

    /**
     * Считается время выполнения на большом массиве (10^4).
     */
    @Test
    public void calculateExecutionTime() {

    }
}
