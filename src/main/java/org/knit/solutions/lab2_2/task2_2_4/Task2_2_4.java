package org.knit.solutions.lab2_2.task2_2_4;

public class Task2_2_4 {
    public static void Run() {
        Warehouse warehouse = new Warehouse();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    warehouse.manufacturer("товар " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    warehouse.consumer();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
