package org.knit.solutions.Task5;

public class Waiter {
    private int availableDish = 3;

    public synchronized void acquireDish(String name) throws InterruptedException {
        while (availableDish == 0) {
            System.out.println("Повар занят, " + name + " ожидает готовки...");
            wait();
        }
        availableDish--;
        System.out.println(name + " готовится...");
    }

    public synchronized void releaseDish(String name) {
        availableDish++;
        System.out.println(name + " готов");
        notify();
    }
}
