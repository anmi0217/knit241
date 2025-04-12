import org.junit.Assert;
import org.junit.Test;
import org.knit.solutions.task18.DuplicateZeros;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class DuplicateZerosTest {
    DuplicateZeros duplicateZeros = new DuplicateZeros();
    @Test
    public void Example1(){
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros.duplicateZeros(arr1);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr1);
    }

    @Test
    public void Example2(){
        // Обычный случай без нулей
        int[] arr2 = {1, 2, 3};
        duplicateZeros.duplicateZeros(arr2);
        assertArrayEquals(new int[]{1, 2, 3}, arr2);
    }

    @Test
    public void Example3(){
        // Крайний случай: пустой массив
        int[] arr3 = {};
        duplicateZeros.duplicateZeros(arr3);
        assertArrayEquals(new int[]{}, arr3);
    }

    @Test
    public void Example4(){
        // Крайний случай: все нули
        int[] arr4 = {0, 0, 0};
        duplicateZeros.duplicateZeros(arr4);
        assertArrayEquals(new int[]{0, 0, 0}, arr4);
    }

    @Test
    public void Example5(){
        // Крайний случай: нули на границах
        int[] arr5 = {0, 1, 2, 3, 0};
        duplicateZeros.duplicateZeros(arr5);
        assertArrayEquals(new int[]{0, 0, 1, 2, 3}, arr5);
    }

    @Test
    public void Example6(){
        // Производительность: большой массив
        int[] largeArr = new int[10000000];
        Arrays.fill(largeArr, 1);
        largeArr[5000] = 0; // Один ноль в середине

        long startTime = System.currentTimeMillis();
        duplicateZeros.duplicateZeros(largeArr);
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения для большого массива: " + (endTime - startTime) + " ms");

        assertFalse("Не пройдешь: ", endTime - startTime > 10);
    }
}
