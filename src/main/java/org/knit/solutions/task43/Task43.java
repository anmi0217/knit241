package org.knit.solutions.task43;

import java.util.Arrays;

public class Task43 {
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 3, 6, 0, 0, 0};
        int m = 5;
        int[] a2 = {2, 4, 7};
        int n = 3;
        mergeArrays(a1, m, a2, n);
        System.out.println(Arrays.toString(a1));
    }

    /**
     * Объединяет два массива, отсортированных в неубывающем порядке.
     * Первый входной массив должен иметь достаточную длину,
     * чтобы вместить элементы обоих массивов.
     *
     * @param a1 Первый входной массив длины m + n (изменяется на месте).
     * @param m  Количество значащих элементов в первом входном массиве.
     * @param a2 Второй входной массив длины n (изменяется на месте).
     * @param n  Длина второго входного массива.
     */
    public static void mergeArrays(int[] a1, int m, int[] a2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m + n) {
            if (k < m) {
                if (j < n && a1[i] > a2[j]) {
                    for (int l = m + n - 1; l > i; l--) {
                        a1[l] = a1[l - 1];
                    }
                    a1[i] = a2[j];
                    j++;
                } else {
                    k++;
                }
            } else {
                a1[i] = a2[j];
                j++;
            }
            i++;
        }
    }
}
