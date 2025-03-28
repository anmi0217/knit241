package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab10.Task22.Dictionary;

import org.knit.TaskDescription;

/**
 * Задача 22: Универсальный словарь
 * <p>
 * Описание:
 * 1. Создать класс Dictionary<K, V>, который будет работать как словарь (ключ-значение).
 * 2. Реализовать методы для добавления, удаления и получения элементов.
 */

@TaskDescription(taskNumber = 22,
        taskDescription = "Универсальный словарь",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task22 implements Solution {
    public void execute() {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);

        System.out.println(dictionary.get("Alice")); // 25
        System.out.println(dictionary.get("key")); // null

        dictionary.remove("Alice");
        System.out.println(dictionary.get("Alice")); // null
    }
}

