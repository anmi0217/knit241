/*
2.8 Задача «Перекресток: светофор и машины» 🚦🚗

📌 Описание:
На перекрестке светофор управляет движением:

Красный свет – машины стоят (wait()).
Зеленый свет – машины едут (notifyAll()).
Светофор переключается каждые 5 секунд.
🔹 Что нужно реализовать?
✔ Поток "Светофор" изменяет цвет и отправляет notifyAll().
✔ Потоки "Машина" ждут wait(), если красный свет.
 */

package org.knit.solutions.org2.lab8;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task8 {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight(); // Создаем светофор

        // Создаем пул потоков для машин
        ExecutorService carExecutor = Executors.newFixedThreadPool(5);

        // Создаем и запускаем потоки для машин
        for (int i = 1; i <= 5; i++) {
            carExecutor.execute(new Car(trafficLight, "Машина " + i));
        }

        // Создаем и запускаем поток для светофора
        Thread trafficLightThread = new Thread(() -> {
            try {
                trafficLight.switchLight();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Светофор прерван.");
            }
        });
        trafficLightThread.start();

        // Ожидаем завершения работы потоков (в реальной задаче это может быть бесконечно)
        try {
            trafficLightThread.join();
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
        }

        carExecutor.shutdown(); // Завершаем пул потоков
    }
}
