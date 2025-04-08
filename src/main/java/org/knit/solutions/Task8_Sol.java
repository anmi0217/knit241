package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task8.Car;
import org.knit.solutions.Task8.TrafficController;
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

@TaskDescription(taskNumber = 8, taskDescription = "Перекресток: светофор и машины", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task8_Sol implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 8 запущена");
        TrafficLight trafficLight = new TrafficLight();

        TrafficController controller = new TrafficController(trafficLight);
        controller.start();

        for (int i = 1; i <= 5; i++) {
            Car car = new Car(trafficLight, "Машина " + i);
            car.start();
        }
    }
}
