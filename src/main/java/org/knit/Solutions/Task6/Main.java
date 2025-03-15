package org.knit.Solutions.Task6;

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

import org.knit.Solutions.TasksDescripton;

@TasksDescripton(number = 6, name = "2.6 Задача «Железнодорожный переезд»")

public class Main {
    public static void main(String[] args) {
        RailroadCrossing crossing = new RailroadCrossing();

        Train train = new Train(crossing);
        train.start();

        for (int i = 1; i <= 10; i++) {
            new Car(crossing, "Машина " + i).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
