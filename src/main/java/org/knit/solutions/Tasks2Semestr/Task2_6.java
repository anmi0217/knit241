package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.task3.RailwayCrossing;
import org.knit.solutions.Solution;

/**
 * Задача 2.6: Железнодорожный переезд
 *
 * Условие:
 * - Машины едут через переезд.
 * - Если приближается поезд, машины ждут.
 * - После проезда поезда, машины продолжают путь.
 *
 * wait() / notifyAll() используются для синхронизации.
 */

@TaskDescription(taskNumber = 6,
        taskDescription = "Железнодорожный переезд",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_6 implements Solution {
    public void execute() {
        RailwayCrossing crossing = new RailwayCrossing();

        // Поток поезда: каждые 10 секунд поезд едет
        Thread trainThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(10000); // ожидание следующего поезда
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                crossing.arriveTrain();
            }
        });

        // Потоки машин: каждая машина едет циклично
        for (int i = 1; i <= 5; i++) {
            final String carName = "Машина " + i;
            new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    crossing.passCar(carName);
                    try {
                        Thread.sleep(5000); // время между попытками проехать
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }

        trainThread.start();
    }
}
