package org.knit.solutions.TaskSem2;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab2.task2.Restaurant;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 2.5: Ресторан - Повар и Официант
 * <p>
 * Описание:
 * - Повар готовит блюда и кладет их на поднос (максимум 3 блюда).
 * - Официант забирает готовые блюда и подает их клиентам.
 * <p>
 * Требования:
 * - Повар ждет (wait()), если на подносе уже 3 блюда.
 * - Официант ждет (wait()), если поднос пуст.
 * - notify() используется при каждой передаче блюда.
 */

@TaskDescription(taskNumber = 5,
        taskDescription = "Ресторан - Повар и Официант",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_5 implements Solution {
    public void execute() {
        Restaurant restaurant = new Restaurant();

        // Поток повара (готовит блюда)
        Thread chef = new Thread(() -> {
            while (true) {
                restaurant.cook();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Поток официанта (раздает блюда)
        Thread waiter = new Thread(() -> {
            while (true) {
                restaurant.serve();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        chef.start();
        waiter.start();
    }
}
