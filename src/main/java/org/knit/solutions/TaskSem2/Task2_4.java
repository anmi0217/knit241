package org.knit.solutions.TaskSem2;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab2.task1.GasStation;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 2.4: Автозаправочная станция
 * <p>
 * Описание:
 * На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
 * Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.
 * <p>
 * Требования:
 * - Использовать wait() и notify() для синхронизации потоков.
 * - Поток "Машина" должен ожидать, если все колонки заняты.
 * - Поток "Машина" заправляется, затем освобождает колонку.
 */

@TaskDescription(taskNumber = 4,
        taskDescription = "Автозаправочная станция",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_4 implements Solution {
    public void execute() {
        GasStation station = new GasStation(2);

        for (int i = 1; i <= 7; i++) {
            String carName = "Машина " + i;
            new Thread(() -> station.refuel(carName)).start();
        }
    }
}



