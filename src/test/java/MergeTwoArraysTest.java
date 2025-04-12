import org.junit.Test;
import org.knit.solutions.task19.MergeTwoArrays;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class MergeTwoArraysTest {
    MergeTwoArrays solution = new MergeTwoArrays();

    @Test
    public void Example1(){
        // Обычный случай
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        solution.merge(arr1, 3, arr2, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, arr1);
    }

    @Test
    public void Example2() {
        // Второй массив пуст
        int[] arr3 = {1};
        int[] arr4 = {};
        solution.merge(arr3, 1, arr4, 0);
        assertArrayEquals(new int[]{1}, arr3);
    }

    @Test
    public void Example3() {
        // Первый массив пуст, но имеет место
        int[] arr5 = {0};
        int[] arr6 = {1};
        solution.merge(arr5, 0, arr6, 1);
        assertArrayEquals(new int[]{1}, arr5);
    }

    @Test
    public void Example4() {
        // Отрицательные числа и дубликаты
        int[] arr7 = {-3, -1, 0, 0, 0, 0};
        int[] arr8 = {-2, -2, 4};
        solution.merge(arr7, 3, arr8, 3);
        assertArrayEquals(new int[]{-3, -2, -2, -1, 0, 4}, arr7);
    }
    @Test
    public void Example5() {
        // Производительность: большой массив
        int[] largeArr1 = new int[20000000];
        int[] largeArr2 = new int[1000000];
        Arrays.fill(largeArr1, 0, 100, 1);
        Arrays.fill(largeArr2, 2);

        long startTime = System.currentTimeMillis();
        solution.merge(largeArr1, 100, largeArr2, 100);
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения для больших массивов: " + (endTime - startTime) + " ms");

        assertFalse("Не пройдешь: ", endTime - startTime > 100);
    }
}
