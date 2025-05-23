package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.task2.Restaurant;
import org.knit.solutions.Solution;

/**
 * Задача 2.5: Ресторан - Повар и Официант
 *
 * Условие:
 * - Повар готовит блюда и кладёт их на поднос (макс. 3).
 * - Официант забирает блюда и подаёт их клиентам.
 *
 * Требования:
 * - Повар ждёт, если поднос полон.
 * - Официант ждёт, если поднос пуст.
 * - Оповещение через notifyAll() после каждого действия.
 */

@TaskDescription(taskNumber = 5,
        taskDescription = "Ресторан - Повар и Официант",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_5 implements Solution {
    public void execute() {
        Restaurant restaurant = new Restaurant();

        // Поток: Повар
        Thread chef = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                restaurant.cook();
                try {
                    Thread.sleep(3000); // симуляция времени приготовления
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Поток: Официант
        Thread waiter = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                restaurant.serve();
                try {
                    Thread.sleep(5000); // симуляция времени подачи блюда
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        chef.start();
        waiter.start();
    }
}
