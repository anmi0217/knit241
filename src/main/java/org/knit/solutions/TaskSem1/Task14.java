package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab9.Task14.TrafficLight;
import java.util.Scanner;

import org.knit.TaskDescription;
/***
 * Задача 14
 * Создайте Enum TrafficLight с состояниями светофора: RED, YELLOW, GREEN.
 * Добавьте метод getNextLight(), который возвращает следующее состояние светофора.
 * Напишите программу, которая:
 1. Запрашивает текущий сигнал светофора.
 2. Выводит следующий сигнал.
 */
@TaskDescription(taskNumber = 14,
        taskDescription = "Цвета светофора",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task14 implements Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine().toUpperCase();

        TrafficLight currentLight = TrafficLight.valueOf(input);

        TrafficLight nextLight = currentLight.getNextLight();
        System.out.println("Следующий сигнал: " + nextLight);
    }
}

