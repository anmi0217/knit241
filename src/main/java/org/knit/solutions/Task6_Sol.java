package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task6.Car;
import org.knit.solutions.Task6.RailroadCrossing;
import org.knit.solutions.Task6.Train;

/*
📌 Описание:
Есть автомобили и поезд.

Если поезд приближается, машины останавливаются и ждут.
После того, как поезд проедет, машины продолжают движение.
🔹 Что нужно реализовать?
✔ Поток "Поезд" останавливает автомобили (wait()).
✔ Поток "Поезд" сообщает о завершении (notifyAll()).
✔ Машины ждут, если поезд едет, и продолжают движение после notifyAll().
 */

@TaskDescription(taskNumber = 6, taskDescription = "Железнодорожный переезд", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task6_Sol implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 6 запущена");
        RailroadCrossing crossing = new RailroadCrossing();

        Train train = new Train(crossing);
        train.start();

        for (int i = 1; i <= 5; i++) {
            Car car = new Car(crossing, "Машина " + i);
            car.start();
        }
    }
}
