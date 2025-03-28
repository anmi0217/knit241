package org.knit.solutions.TaskSem1;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab9.Task15.Seasons;

/**
 * Задача 15: Времена года
 * <p>
 * Описание:
 * 1. Создать перечисление (Enum) для времён года (Season).
 * 2. Для каждого сезона задать среднюю температуру (например, "Холодно", "Тепло").
 * 3. Добавить типичный праздник для каждого времени года (например, "Новый год" для зимы).
 * 4. Вывести информацию обо всех временах года, используя метод values().
 * <p>
 * Требования:
 * - Использовать Enum для представления сезонов.
 * - Хранить температуру и праздник как поля Enum.
 * - Реализовать метод для вывода информации о каждом сезоне.
 */


@TaskDescription(taskNumber = 15,
        taskDescription = "Времена года",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task15 implements Solution {
    public void execute() {
        for (Seasons season : Seasons.values()) {
            System.out.println(season + ": " + season.getTemperature() +
                    ", типичный праздник - " + season.getHoliday());
        }
    }
}