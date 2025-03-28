package org.knit.solutions.ClassesSem2.lab2.task1;

public class GasStation {
    private final int maxPumps;
    private int availablePumps;

    public GasStation(int maxPumps) {
        this.maxPumps = maxPumps;
        this.availablePumps = maxPumps;
    }

    public void refuel(String carName) {
        System.out.println(carName + " подъехала к АЗС.");
        synchronized (this) {
            while (availablePumps == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        synchronized (this) {
            availablePumps--;
        }
        System.out.println(carName + " заправляется (Свободных колонок: " + availablePumps + ")");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        synchronized (this) {
            availablePumps++;
            System.out.println(carName + " заправилась");
            notifyAll();
        }
    }
}