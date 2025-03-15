package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task4.Car;
import org.knit.solutions.Task4.GasStation;

/*
📌 Описание:
На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.

🔹 Что нужно реализовать?
✔ Использовать wait() и notify() для ожидания и освобождения заправки.
✔ Поток "Машина" ждет, если все колонки заняты.
✔ Поток "Машина" заправляется, затем освобождает колонку.
 */

@TaskDescription(taskNumber = 4, taskDescription = "Автозаправочная станция")
public class Task4Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 4 запущена");

        int totalCars = 10;
        GasStation gasStation = new GasStation(totalCars);

        for (int i = 1; i <= totalCars; i++) {
            Car car = new Car("Car-" + i, gasStation);
            car.start();
        }
    }
}
