package org.knit.Solutions.Task8;

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

import org.knit.Solutions.TasksDescripton;

@TasksDescripton(number = 8, name = "2.8 Задача «Перекресток: светофор и машины» ")

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        TrafficLightController controller = new TrafficLightController(trafficLight);
        controller.start();

        for (int i = 1; i <= 10; i++) {
            new Car(trafficLight, "Машина " + i).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}