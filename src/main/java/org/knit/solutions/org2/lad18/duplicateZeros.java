package org.knit.solutions.org2.lad18;
import org.knit.TaskDescription;


public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        System.out.println("RUN START");
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                // Сдвигаем элементы вправо
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                // Вставляем дублированный ноль
                arr[i + 1] = 0;
                i++; // Пропускаем только что вставленный ноль
            }
        }
    }
}
