/*
2.7 Задача «Производитель-Потребитель с ограничением» 🏭📦

📌 Описание:

Производитель создает товары (максимум 5).
Потребитель забирает товары.
Если товаров нет, потребитель ждет (wait()).
Если товаров максимум, производитель ждет (wait()).
🔹 Что нужно реализовать?
✔ wait() – если товаров нет или склад заполнен.
✔ notify() – пробуждение потока, когда изменяется состояние склада.
 */

package org.knit.solutions.org2.lab7;

import org.knit.solutions.annotations.Discription;

@Discription(value = 7, name = "Производитель-Потребитель с ограничением")
public class Task7 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(); // Создаем склад

        // Создаем потоки для производителя и потребителя
        Thread producerThread = new Thread(new Producer(warehouse));
        Thread consumerThread = new Thread(new Consumer(warehouse));

        // Запускаем потоки
        producerThread.start();
        consumerThread.start();

        // Ожидаем завершения потоков
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
        }

        System.out.println("Работа завершена.");
    }
}
