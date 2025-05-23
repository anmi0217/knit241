package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.task5.Warehouse;
import org.knit.solutions.Solution;

/**
 * Задача 2.7: Производитель–Потребитель с ограничением
 *
 * Условия:
 * - Склад вмещает максимум 5 товаров.
 * - Производитель производит, если есть место.
 * - Потребитель потребляет, если есть товар.
 * - Используются wait() и notifyAll() для координации.
 */

@TaskDescription(taskNumber = 7,
        taskDescription = "Производитель-Потребитель с ограничением",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_7 implements Solution {
    public void execute() {
        Warehouse warehouse = new Warehouse();

        Thread producer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                warehouse.produce();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                warehouse.consume();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
