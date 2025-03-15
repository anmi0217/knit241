package org.knit.solutions.lab2_2.task2_2_2;

public class Task2_2_2 {
    public static void Run() {
        Restaurant restaurant = new Restaurant();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    restaurant.cook("блюдо " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    restaurant.serve();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
