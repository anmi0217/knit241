package org.knit.solutions.ClassesSem2.lab2.task6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Workshop { // Цех с тремя рабочими
    private final BlockingQueue<Integer> stampingQueue = new LinkedBlockingQueue<>(5); // Очередь для штамповщика
    private final BlockingQueue<Integer> assemblyQueue = new LinkedBlockingQueue<>(5); // Очередь для сборщика
    private int partId = 1;

    public void startProduction() {
        // Поток ШТАМПОВЩИКА
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(500); // Время на создание заготовки
                    System.out.println("Штамповщик: Заготовка " + partId + " создана");
                    stampingQueue.put(partId++); // Поток блокируется здесь, если очередь полна
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Поток СБОРЩИКА
        new Thread(() -> {
            try {
                while (true) {
                    int part = stampingQueue.take();
                    System.out.println("Сборщик: Взял " + part);
                    Thread.sleep(3000);
                    System.out.println("Сборщик: Заготовка " + part + " обработана");
                    assemblyQueue.put(part);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Поток ОПЕРАТОРА КОНТРОЛЯ
        new Thread(() -> {
            try {
                while (true) {
                    int part = assemblyQueue.take();
                    System.out.println("Оператор контроля: Деталь " + part + " принята в работу");
                    Thread.sleep(4000); // Время на проверку
                    System.out.println("Оператор контроля: Деталь " + part + " проверена и отправлена на склад");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
