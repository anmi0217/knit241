package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task5.Chef;
import org.knit.solutions.Task5.Restaurant;
import org.knit.solutions.Task5.Waiter;

/*
📌 Описание:
В ресторане работает один повар и один официант.

Повар готовит блюда и ставит их на поднос (максимум 3 блюда).
Официант берет готовые блюда и подает их клиентам.
🔹 Что нужно реализовать?
✔ Повар не может готовить больше 3 блюд (ждет wait()).
✔ Официант ждет, если поднос пуст (wait()).
✔ При каждой передаче блюда используется notify().
 */

@TaskDescription(taskNumber = 5, taskDescription = "Ресторан: Повар и Официант")
public class Task5Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 5 запущена");

        Restaurant restaurant = new Restaurant();

        Chef chef = new Chef("Повар-1", restaurant);
        Waiter waiter = new Waiter("Официант-1", restaurant);

        chef.start();
        waiter.start();
    }
}
