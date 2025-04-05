package org.knit.solutions.TaskSem2;


import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab2.task5.Warehouse;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 2.7: Производитель-Потребитель с ограничением 🏭📦
 * <p>
 * Описание:
 * - Производитель создает товары (максимум 5).
 * - Потребитель забирает товары.
 * - Если товаров нет, потребитель ждет (wait()).
 * - Если товаров максимум, производитель ждет (wait()).
 * <p>
 * Требования:
 * - Использовать wait() для ожидания, когда склад заполнен или пуст.
 * - Использовать notify() для пробуждения потока при изменении состояния склада.
 */

@TaskDescription(taskNumber = 7,
        taskDescription = "Производитель-Потребитель с ограничением",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_7 implements Solution {
    public void execute() {
        Warehouse warehouse = new Warehouse();

        // Поток производителя
        Thread producer = new Thread(() -> {
            while (true) {
                warehouse.produce();
                try {
                    Thread.sleep(1000); // Производитель добавляет товар каждую секунду
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Поток потребителя
        Thread consumer = new Thread(() -> {
            while (true) {
                warehouse.consume();
                try {
                    Thread.sleep(3000); // Потребитель забирает товар каждые 1.5 секунды
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

