package org.knit.solutions.lab2.task6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Workshop {

    private final BlockingQueue<Integer> rawParts = new LinkedBlockingQueue<>(5);
    private final BlockingQueue<Integer> readyParts = new LinkedBlockingQueue<>(5);
    private int nextId = 1;

    public void startProduction() {
        // Заготовщик
        Thread cutter = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(500);
                    int id = nextId++;
                    System.out.println("Заготовка №" + id + " готова");
                    rawParts.put(id);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Сборщик
        Thread builder = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int raw = rawParts.take();
                    System.out.println("Сборка детали №" + raw + " начата");
                    Thread.sleep(3000);
                    System.out.println("Сборка детали №" + raw + " завершена");
                    readyParts.put(raw);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Контроль
        Thread inspector = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int checked = readyParts.take();
                    System.out.println("Контроль детали №" + checked + " запущен");
                    Thread.sleep(4000);
                    System.out.println("Деталь №" + checked + " прошла проверку");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        cutter.start();
        builder.start();
        inspector.start();
    }
}
