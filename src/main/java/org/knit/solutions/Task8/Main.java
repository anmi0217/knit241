package org.labs.Tasks2.Task8;

import org.labs.TasksDescripton;

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

@TasksDescripton(number = 8, name = "Перекресток: светофор и машины")
public class Main {
    public static void main(String[] args) {
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

