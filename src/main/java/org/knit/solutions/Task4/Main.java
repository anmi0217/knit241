package org.labs.Tasks2.Task4;

import org.labs.TasksDescripton;

/*
📌 Описание:
На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.

🔹 Что нужно реализовать?
✔ Использовать wait() и notify() для ожидания и освобождения заправки.
✔ Поток "Машина" ждет, если все колонки заняты.
✔ Поток "Машина" заправляется, затем освобождает колонку.
 */

@TasksDescripton(number = 4, name = "Автозаправочная станция")
public class Main {
    public static void main(String[] args) {
        int totalCars = 10;
        GasStation gasStation = new GasStation(totalCars);

        for (int i = 1; i <= totalCars; i++) {
            Car car = new Car("Car-" + i, gasStation);
            car.start();
        }
    }
}