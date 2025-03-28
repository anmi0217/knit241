package org.knit.solutions.TaskSem1;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 23: Печать типа объекта
 * <p>
 * Описание:
 * 1. Напишите универсальный метод printType, который принимает объект любого типа.
 * 2. Метод должен выводить на экран имя класса объекта.
 */
@TaskDescription(taskNumber = 23,
        taskDescription = "Печать типа объекта",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task23 implements Solution {
    public void execute() {
        printType(123);
        printType("Hello");
        printType(2.4);
        printType(new Integer[]{1, 2, 3});
    }

    public static <T> void printType(T object) {
        if (object == null) {
            System.out.println("Тип объекта: null");
        } else {
            System.out.println("Тип объекта: " + object.getClass().getName());
        }
    }
}
