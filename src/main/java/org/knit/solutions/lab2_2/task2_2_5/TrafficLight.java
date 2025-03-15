package org.knit.solutions.lab2_2.task2_2_5;

public class TrafficLight implements Runnable {
    private static final Object lock = new Object();
    private static boolean isGreen = false;

    public static boolean isGreen() {
        return isGreen;
    }

    public static Object getLock() {
        return lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                synchronized (lock) {
                    isGreen = true;
                    System.out.println("🟢 Светофор: Зелёный!");
                    lock.notifyAll();
                }

                Thread.sleep(5000);
                synchronized (lock) {
                    isGreen = false;
                    System.out.println("🔴 Светофор: Красный!");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}