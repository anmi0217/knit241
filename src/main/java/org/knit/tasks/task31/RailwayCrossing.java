package org.knit.tasks.task31;

public class RailwayCrossing {
    private boolean isRailwayCrossingClosed = false;

    public synchronized void train() {
        isRailwayCrossingClosed = true;
        System.out.println("Поезд подъезжает.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Поезд проехал.");
        isRailwayCrossingClosed = false;
        notifyAll();
    }

    public synchronized void car(int carId) {
        while (isRailwayCrossingClosed) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Машина " + carId + " проехала.");
    }
}
