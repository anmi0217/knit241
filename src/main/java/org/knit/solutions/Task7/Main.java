package org.labs.Tasks2.Task7;

import org.labs.TasksDescripton;

/*
📌 Описание:

Производитель создает товары (максимум 5).
Потребитель забирает товары.
Если товаров нет, потребитель ждет (wait()).
Если товаров максимум, производитель ждет (wait()).
🔹 Что нужно реализовать?
✔ wait() – если товаров нет или склад заполнен.
✔ notify() – пробуждение потока, когда изменяется состояние склада.
 */

@TasksDescripton(number = 7, name = "Производитель-Потребитель с ограничением")
public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Producer producer = new Producer("Производитель-1", warehouse);
        Consumer consumer = new Consumer("Потребитель-1", warehouse);

        producer.start();
        consumer.start();
    }
}
