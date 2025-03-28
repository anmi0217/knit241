package org.knit.solutions.ClassesSem2.lab2.task4;

public class TrafficLight {
    private boolean isGreen = true;

    // Метод для переключения светофора
    public synchronized void switchLight() {

        isGreen = !isGreen;

        if (isGreen) {
            System.out.println("Зеленый свет! Машины могут ехать.");
            notifyAll();
        } else {
            System.out.println("Красный свет! Машины стоят.");
            notifyAll();
        }

    }

    // Метод для машины (машина будет ждать, если красный свет)
    public synchronized void carArrive(String carName) {
        while (!isGreen) {
            System.out.println(carName + " Ждёт");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(carName + " проехала через перекрёсток!");
    }
}

