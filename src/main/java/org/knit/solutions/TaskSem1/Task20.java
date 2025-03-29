package org.knit.solutions.TaskSem1;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab10.Task20.Box;

/**
 * Задача 20: Универсальный контейнер с ограничениями
 * <p>
 * Описание:
 * 1. Создать класс Box с ограничением типа T extends Number.
 * 2. Реализовать метод для вычисления суммы всех чисел, хранящихся в контейнере.
 */

@TaskDescription(taskNumber = 20,
        taskDescription = "Универсальный контейнер с ограничениями",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task20 implements Solution {
    public void execute() {
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        System.out.println(integerBox.sum()); // 30

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        System.out.println(doubleBox.sum()); // 4.0
    }
}

