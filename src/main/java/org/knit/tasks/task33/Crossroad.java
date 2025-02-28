package org.knit.tasks.task33;

public class Crossroad {
    private boolean isRedLightOn = false;

    public synchronized void trafficLight() {
        if (isRedLightOn) {
            isRedLightOn = false;
            System.out.println("Загорелся зелёный свет.");
            notifyAll();
        } else {
            isRedLightOn = true;
            System.out.println("Загорелся красный свет.");
        }
    }

    public synchronized void car(int carId) {
        while (isRedLightOn) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Машина " + carId + " проехала.");
    }
}
