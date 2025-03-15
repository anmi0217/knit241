package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task6.RailwayCrossing;
import org.knit.solutions.Task6.Car;
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

@TaskDescription(taskNumber = 6, taskDescription = "Железнодорожный переезд")
public class Task6Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 6 запущена");

        RailwayCrossing crossing = new RailwayCrossing();

        Car car1 = new Car("Car-1", crossing);
        Car car2 = new Car("Car-2", crossing);
        Car car3 = new Car("Car-3", crossing);

        Train train = new Train("Train-1", crossing);

        car1.start();
        car2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        train.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        car3.start();

    }
}

