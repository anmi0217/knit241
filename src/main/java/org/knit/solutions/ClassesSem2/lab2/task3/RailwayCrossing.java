package org.knit.solutions.ClassesSem2.lab2.task3;

public class RailwayCrossing {
    private boolean trainComing = false; // Поезд едет?

    public synchronized void arriveTrain() {
        System.out.println("Поезд приближается!");
        trainComing = true;

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        trainComing = false;
        System.out.println("Поезд проехал! Дорога свободна!");
        notifyAll();
    }

    public synchronized void passCar(String carName) {
        while (trainComing) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(carName + " проехала через переезд!");
    }
}
