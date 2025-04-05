package org.knit.solutions.TaskSem1;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab10.Task18.Pair;

/**
 * Задача 18: Создание универсального класса Pair
 *
 * Описание:
 * 1. Создать универсальный класс Pair, который будет хранить две связанные сущности.
 * 2. Класс должен быть универсальным, то есть работать с любыми типами данных.
 * 3. Написать методы для получения и изменения значений этих сущностей.
 * 4. Методы должны возвращать значение пары и позволять изменять элементы пары.
 *
 * Требования:
 * - Класс должен быть универсальным (использовать параметризированные типы).
 * - Реализовать методы getFirst() и getSecond() для получения значений.
 * - Реализовать методы setFirst() и setSecond() для изменения значений.
 * - Продемонстрировать использование класса Pair с разными типами данных (например, Integer, String, и т.д.).
 */

@TaskDescription(taskNumber = 18,
        taskDescription = "Создание универсального класса Pair",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task18 implements Solution {
    public void execute() {
        Pair<String, Integer> pair = new Pair<>("Age", 30);

        System.out.println(pair.getFirst()); // Age
        System.out.println(pair.getSecond()); // 30

        pair.setSecond(35);
        System.out.println(pair.getSecond()); // 35

        pair.setFirst("aaaa");
        System.out.println(pair.getFirst());

    }
}


