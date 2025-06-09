package org.knit.solutions.org2.lad18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DuplicateZerosTest {
    @org.junit.jupiter.api.Test
    public void testNormalCaseses() {
        DuplicateZeros duplicateZeros = new DuplicateZeros();

        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros.duplicateZeros(arr1);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr1);

        int[] arr2 = {1, 2, 3};
        duplicateZeros.duplicateZeros(arr2);
        assertArrayEquals(new int[]{1, 2, 3}, arr2);
    }

    @org.junit.jupiter.api.Test
    public void testEdgeCases() {
        DuplicateZeros duplicateZeros = new DuplicateZeros();

        int[] emptyArray = {};
        duplicateZeros.duplicateZeros(emptyArray);
        assertArrayEquals(new int[]{}, emptyArray);

        int[] allZeros = {0, 0, 0};
        duplicateZeros.duplicateZeros(allZeros);
        assertArrayEquals(new int[]{0, 0, 0}, allZeros);

        int[] zeroAtEdge = {0, 1, 2, 3, 0};
        duplicateZeros.duplicateZeros(zeroAtEdge);
        assertArrayEquals(new int[]{0, 0, 1, 2, 3}, zeroAtEdge);
    }

    @Test
    void testPerformance() {
        DuplicateZeros duplicateZeros = new DuplicateZeros();

        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i % 2 == 0 ? 0 : 1;
        }
        long startTime = System.currentTimeMillis();
        duplicateZeros.duplicateZeros(largeArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}
