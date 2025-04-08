package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task5.*;

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

@TaskDescription(taskNumber = 5, taskDescription = "Ресторан: Повар и Официант", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task5_Sol implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 5 запущена");
        Waiter waiter = new Waiter();


        Dish1 dish1 = new Dish1(waiter);
        Dish2 dish2 = new Dish2(waiter);
        Dish3 dish3 = new Dish3(waiter);
        Dish4 dish4 = new Dish4(waiter);
        Dish5 dish5 = new Dish5(waiter);
        dish1.start();
        dish2.start();
        dish3.start();
        dish4.start();
        dish5.start();
    }
}