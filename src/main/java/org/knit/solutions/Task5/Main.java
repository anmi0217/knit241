package org.labs.Tasks2.Task5;

import org.labs.TasksDescripton;

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

@TasksDescripton(number = 5, name = "Ресторан: Повар и Официант")
public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Chef chef = new Chef("Повар-1", restaurant);
        Waiter waiter = new Waiter("Официант-1", restaurant);

        chef.start();
        waiter.start();
    }
}
