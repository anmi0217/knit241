package org.knit.Solutions.Task4;

class GasStation {
    private int availablePumps = 2;

    public synchronized void refuel(String carName) {
        while (availablePumps == 0) {
            try {
                System.out.println(carName + " ждет свою очередь на заправку...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        availablePumps--;
        System.out.println(carName + " начал заправку...");

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (this) {
                availablePumps++;
                System.out.println(carName + " завершил заправку и уезжает.");
                notifyAll();
            }
        }).start();
    }
}