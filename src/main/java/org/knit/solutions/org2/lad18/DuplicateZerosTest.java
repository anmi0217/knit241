package org.knit.solutions.org2.lad18;

import org.junit.jupiter.api.Test;
import org.knit.solutions.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DuplicateZerosTest {

    @Test
    void testNormalCases() {
        Solution solution = new Solution() {
            @Override
            public void execute() {

            }

            @Override
            public void duplicateZeros(int[] arr1) {

            }
        };

        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr1);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr1);

        int[] arr2 = {1, 2, 3};
        solution.duplicateZeros(arr2);
        assertArrayEquals(new int[]{1, 2, 3}, arr2);
    }

    @Test
    void testEdgeCases() {
        Solution solution = new Solution() {
            @Override
            public void execute() {

            }

            @Override
            public void duplicateZeros(int[] arr1) {

            }
        };

        int[] emptyArray = {};
        solution.duplicateZeros(emptyArray);
        assertArrayEquals(new int[]{}, emptyArray);

        int[] allZeros = {0, 0, 0};
        solution.duplicateZeros(allZeros);
        assertArrayEquals(new int[]{0, 0, 0}, allZeros);

        int[] zeroAtEdge = {0, 1, 2, 3, 0};
        solution.duplicateZeros(zeroAtEdge);
        assertArrayEquals(new int[]{0, 0, 1, 2, 3}, zeroAtEdge);
    }

    @Test
    void testPerformance() {
        Solution solution = new Solution() {
            @Override
            public void execute() {

            }

            @Override
            public void duplicateZeros(int[] arr1) {

            }
        };

        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i % 2 == 0 ? 0 : 1;
        }
        long startTime = System.currentTimeMillis();
        solution.duplicateZeros(largeArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}

