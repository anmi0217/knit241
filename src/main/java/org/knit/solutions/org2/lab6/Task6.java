/*
2.6 Задача «Железнодорожный переезд» 🚆🚗
📌 Описание:
Есть автомобили и поезд.

Если поезд приближается, машины останавливаются и ждут.
После того, как поезд проедет, машины продолжают движение.
🔹 Что нужно реализовать?
✔ Поток "Поезд" останавливает автомобили (wait()).
✔ Поток "Поезд" сообщает о завершении (notifyAll()).
✔ Машины ждут, если поезд едет, и продолжают движение после notifyAll().
 */


package org.knit.solutions.org2.lab6;
import org.knit.solutions.annotations.Discription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Discription(value = 6, name = "Железнодорожный переезд")
public class Task6 {
    public static void main(String[] args) {
        RailwayCrossing crossing = new RailwayCrossing(); // Создаем переезд

        // Создаем пул потоков для автомобилей
        ExecutorService carExecutor = Executors.newFixedThreadPool(5);

        // Создаем и запускаем потоки для автомобилей
        for (int i = 1; i <= 5; i++) {
            carExecutor.execute(new Car(crossing, "Автомобиль " + i));
        }

        // Создаем и запускаем поток для поезда
        Thread trainThread = new Thread(new Train(crossing));
        trainThread.start();

        // Ожидаем завершения работы потоков (в реальной задаче это может быть бесконечно)
        try {
            trainThread.join();
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
        }

        carExecutor.shutdown(); // Завершаем пул потоков
    }
}
