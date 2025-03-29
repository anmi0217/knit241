package org.dina.lab2_2.Task2_6;

public class Main {
    public static void main(String[] args) {
        Railway railway = new Railway();
        final int CAR_COUNT = 20;

        Thread threadCars = new Thread(() -> {
            for (int i = 1; i <= CAR_COUNT; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                railway.passCar(i + " машина");
            }
        });

        Thread threadTrain = new Thread(() -> {
            try {
                Thread.sleep(500); // время ожидания поезда
                railway.trainIsPassing();
                Thread.sleep(2000); // Поезд едет
                railway.trainPassed();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadCars.start();
        threadTrain.start();

        try {
            threadCars.join(); // Ожидаем завершения потока машин
            threadTrain.join(); // Ожидаем завершения потока поезда
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Программа завершена.");
    }
}