package org.knit.solutions.lab2_2.task2_2_1;

import java.util.concurrent.Semaphore;

public class Petrol {
    private final Semaphore semaphore;

    public Petrol(int count) {
        this.semaphore = new Semaphore(count);
    }

    public void Refuel(String carName) {
        try {
            System.out.println("\uD83D\uDD52" + carName + " ждет заправки...");
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println("✅"+ carName + " завершил заправку");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
