package org.labs.Tasks2.Task4;

public class GasStation {
    private int availableColumns = 2;
    private final int totalCars;
    private int arrivedCars = 0;

    public GasStation(int totalCars) {
        this.totalCars = totalCars;
    }
    public synchronized void arrive(String carName) throws InterruptedException {
        arrivedCars++;
        System.out.println(carName + " прибыла на АЗС. Всего пришли: " + arrivedCars);

        while (arrivedCars < totalCars) {
            wait();
        }
        notifyAll();
    }
    public synchronized void refuel(String carName) throws InterruptedException {
        while (arrivedCars < totalCars) {
            wait();
        }

        while (availableColumns == 0) {
            System.out.println(carName + " ждёт освобождения колонки...");
            wait();
        }

        availableColumns--;
        System.out.println(carName + " начинает заправку. Свободных колонок осталось: " + availableColumns);

        Thread.sleep((long) (Math.random() * 3000 + 1000));

        availableColumns++;
        System.out.println(carName + " завершила заправку. Свободных колонок теперь: " + availableColumns);

        notifyAll();
    }
}

