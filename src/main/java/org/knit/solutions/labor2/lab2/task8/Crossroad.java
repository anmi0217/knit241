package org.knit.solutions.labor2.lab2.task8;

public class Crossroad {

    private boolean isRed = true;

    public synchronized boolean isRed() {
        return isRed;
    }

    public synchronized void waitForGreen() {
        while (isRed) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void changeColor() {
        isRed = !isRed;
        System.out.println((isRed ? "Красный" : "Зеленый") + " свет включен.");
        notifyAll();
    }

    public static void main(String[] args) {
        Crossroad crossroad = new Crossroad();
        Thread threadTrafficLight = new Thread(() -> {
            while (true) {
                crossroad.changeColor();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadCar = new Thread(() -> {
            int i = 1;
            while(true) {
                Car car = new Car(i);
                car.pass(crossroad);
                i++;
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadTrafficLight.start();
        threadCar.start();
    }
}

