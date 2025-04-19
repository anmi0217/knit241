package org.knit.solutions.org2.lad18;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(
        taskNumber = 18,
        taskDescription = "Демонстрация работы дублирования нулей в массиве"
)
public class Task18 implements Solution {
    @Override
    public void execute() {
        DuplicateZeros processor = new DuplicateZeros();

        // Пример 1
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        System.out.println("Пример 1:");
        printArray("До:", arr1);
        processor.duplicateZeros(arr1);
        printArray("После:", arr1);

        // Пример 2
        int[] arr2 = {1, 2, 3};
        System.out.println("\nПример 2:");
        printArray("До:", arr2);
        processor.duplicateZeros(arr2);
        printArray("После:", arr2);
    }

    @Override
    public void duplicateZeros(int[] arr1) {

    }

    private void printArray(String prefix, int[] arr) {
        System.out.print(prefix + " [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}