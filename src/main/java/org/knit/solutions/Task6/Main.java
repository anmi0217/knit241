package org.labs.Tasks2.Task6;

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

import org.labs.TasksDescripton;

@TasksDescripton(number = 6, name = "Железнодорожный переезд")
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RailwayCrossing crossing = new RailwayCrossing();

        Car car1 = new Car("Car-1", crossing);
        Car car2 = new Car("Car-2", crossing);
        Car car3 = new Car("Car-3", crossing);

        Train train = new Train("Train-1", crossing);

        car1.start();
        car2.start();

        Thread.sleep(1000);

        train.start();

        Thread.sleep(500);
        car3.start();
    }
}

