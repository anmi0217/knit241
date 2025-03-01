package org.knit.tasks.task30;

public class Task30 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Thread cookerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaurant.cook(String.valueOf(i));
            }
        });
        Thread waiterThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaurant.serve();
            }
        });
        cookerThread.start();
        waiterThread.start();
    }
}
