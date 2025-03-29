package org.knit.solutions.TaskSem2;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab2.task4.TrafficLight;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 2.8: Перекресток: светофор и машины 🚦🚗
 * <p>
 * Описание:
 * - Красный свет – машины стоят (wait()).
 * - Зеленый свет – машины едут (notifyAll()).
 * - Светофор переключается каждые 5 секунд.
 * <p>
 * Требования:
 * - Поток "Светофор" изменяет цвет и отправляет notifyAll().
 * - Потоки "Машина" ждут wait(), если красный свет.
 */

@TaskDescription(taskNumber = 8,
        taskDescription = "Перекресток: светофор и машины",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_8 implements Solution {
    public void execute() {
        TrafficLight trafficLight = new TrafficLight();

        // Поток светофора
        Thread light = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                trafficLight.switchLight();
            }
        });

        // Потоки машин
        for (int i = 1; i <= 5; i++) {
            String carName = "Машина " + i;
            new Thread(() -> {
                while (true) {
                    trafficLight.carArrive(carName);
                    try {
                        Thread.sleep(2000); // Интервал между появлениями машин на перекрестке
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }

        light.start();
    }
}
