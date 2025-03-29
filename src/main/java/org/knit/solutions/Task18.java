package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_6.Task18Classes.MyList;

import java.util.ArrayList;
import java.util.Arrays;

@TaskDescription(taskNumber = 18, taskDescription = "Написание junit теста для проверки задачи: " +
        "Дан массив целых чисел arr фиксированной длины. Необходимо продублировать каждое вхождение нуля, сдвигая остальные элементы вправо.")
public class Task18 implements Solution{
    @Override
    public void execute() throws Exception {
        MyList list = new MyList(new ArrayList<>(Arrays.asList(4, 0, 9, 0, 4, 0, 9, 7, 7, 8)));
        System.out.println("Исходный список: " + list.getList());
        list.duplicateZeros();
        System.out.println("С удвоенными нолями: " + list.getList());
        System.out.println("Запустите все тесты в src/test/java");
    }
}
