/*
2.4 Задача «Автозаправочная станция» 🚗⛽

📌 Описание:
На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.

🔹 Что нужно реализовать?
✔ Использовать wait() и notify() для ожидания и освобождения заправки.
✔ Поток "Машина" ждет, если все колонки заняты.
✔ Поток "Машина" заправляется, затем освобождает колонку.
 */


package org2.lab4;
import org2.annotations.Discription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Discription(value = 4, name = "Автозаправочная станция")
public class Task4 {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation(2); // Создаем АЗС с 2 колонками

        // Создаем пул потоков для машин, т.е. одновременно могут выполняться до 5 задач одновременно
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Создаем и запускаем потоки для машин
        for (int i = 1; i <= 5; i++) {
            executor.execute(new Car(gasStation, "Машина " + i));
        }

        executor.shutdown(); // Завершаем пул потоков
    }
}
