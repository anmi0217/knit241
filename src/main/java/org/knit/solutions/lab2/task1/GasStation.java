package org.knit.solutions.lab2.task1;

public class GasStation {
    private final int maxPumps;
    private int availablePumps;

    public GasStation(int maxPumps) {
        this.maxPumps = maxPumps;
        this.availablePumps = maxPumps;
    }

    public void refuel(String carName) {
        System.out.println(carName + " подъехала к АЗС.");

        // Ожидаем свободную колонку
        synchronized (this) {
            while (availablePumps == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            availablePumps--;
            System.out.println(carName + " начала заправку (свободно: " + availablePumps + ")");
        }

        // Симуляция заправки
        try {
            Thread.sleep(3000); // 3 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Освобождаем колонку
        synchronized (this) {
            availablePumps++;
            System.out.println(carName + " закончила заправку (теперь свободно: " + availablePumps + ")");
            notifyAll(); // Разбудить ожидающие потоки
        }
    }
}
