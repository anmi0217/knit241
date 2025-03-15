package org.knit.solutions.lab2_2.task2_2_5;

public class Car implements Runnable {
    private final int carId;

    public Car(int id) {
        this.carId = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (TrafficLight.getLock()) {
                    while (!TrafficLight.isGreen()) {
                        System.out.println("🚗 Машина " + carId + " ожидает на красном свете...");
                        TrafficLight.getLock().wait();
                    }
                    System.out.println("🚗 Машина " + carId + " проезжает на зеленый.");
                }
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}