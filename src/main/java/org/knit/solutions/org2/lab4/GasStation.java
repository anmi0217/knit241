package org.knit.solutions.org2.lab4;

import java.util.concurrent.Semaphore;

class GasStation {
    private final Semaphore semaphore;

    public GasStation(int pumpCount) {
        this.semaphore = new Semaphore(pumpCount);
    }

    public void refuel(String carName) throws InterruptedException {
        semaphore.acquire();
        System.out.println(carName + " начала заправку. Доступно колонок: " + semaphore.availablePermits());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(carName + " прервана во время заправки.");
        } finally {
            System.out.println(carName + " завершила заправку. Доступно колонок: " + (semaphore.availablePermits() + 1));
            semaphore.release();
        }
    }
}

