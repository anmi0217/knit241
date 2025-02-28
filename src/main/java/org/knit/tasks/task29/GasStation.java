package org.knit.tasks.task29;

import java.util.concurrent.Semaphore;

public class GasStation {
    private final Semaphore semaphore;

    public GasStation(int pumpsNumber) {
        semaphore = new Semaphore(pumpsNumber);
    }

    public void refuel(String carName) {
        try {
            System.out.println("Машина " + carName + " ждёт заправки.");
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println("Машина " + carName + " заправлена и уехала.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
