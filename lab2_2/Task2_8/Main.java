package org.dina.lab2_2.Task2_8;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        Thread threadTrafficLight = new Thread(() -> {
            while (trafficLight.changeColor()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread threadCar = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Car car = new Car(String.valueOf(i));
                car.pass(trafficLight);
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        threadTrafficLight.start();
        threadCar.start();

        try {
            threadTrafficLight.join();
            threadCar.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Программа завершена.");
    }
}
