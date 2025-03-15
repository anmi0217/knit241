package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task8.Car;
import org.knit.solutions.Task8.TrafficLight;

/*
📌 Описание:
На перекрестке светофор управляет движением:

Красный свет – машины стоят (wait()).
Зеленый свет – машины едут (notifyAll()).
Светофор переключается каждые 5 секунд.
🔹 Что нужно реализовать?
✔ Поток "Светофор" изменяет цвет и отправляет notifyAll().
✔ Потоки "Машина" ждут wait(), если красный свет.
 */

@TaskDescription(taskNumber = 8, taskDescription = "Перекресток: светофор и машины")
public class Task8Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 8 запущена");

        Object lock = new Object();

        TrafficLight trafficLight = new TrafficLight(lock);
        trafficLight.start();

        Car car1 = new Car("Car-1", trafficLight, lock);
        Car car2 = new Car("Car-2", trafficLight, lock);
        Car car3 = new Car("Car-3", trafficLight, lock);

        car1.start();
        car2.start();
        car3.start();
    }
}

