package org.knit.solutions.task18;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int countZeros = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZeros++;
            }
        }

        int i = n - 1;
        int j = n + countZeros - 1;

        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            j--;

            if (arr[i] == 0) {
                if (j < n) {
                    arr[j] = 0;
                }
                j--;
            }
            i--;
        }
    }
}
