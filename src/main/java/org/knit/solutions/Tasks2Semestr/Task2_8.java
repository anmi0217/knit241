package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.task4.TrafficLight;
import org.knit.solutions.Solution;

/**
 * Задача 2.8: Перекресток со светофором
 *
 * Описание:
 * - Светофор переключает сигналы каждые 5 секунд.
 * - Машины проезжают только на зелёный.
 * - Если горит красный — ждут.
 */
@TaskDescription(
        taskNumber = 8,
        taskDescription = "Перекресток: светофор и машины",
        href = "org/knit/solutions/taskExampleClasses/README.md"
)
public class Task2_8 implements Solution {
    public void execute() {
        TrafficLight signalController = new TrafficLight();

        // Светофор
        Thread controller = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                signalController.toggle();
            }
        });

        // Потоки автомобилей
        for (int i = 1; i <= 5; i++) {
            String id = "Авто " + i;
            new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    signalController.approach(id);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }).start();
        }

        controller.start();
    }
}
