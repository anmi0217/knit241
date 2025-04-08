package org.knit.solutions.Task8;


public class TrafficLight {
    private boolean greenLight = false;

    public synchronized void switchLight() {
        greenLight = !greenLight;
        if (greenLight) {
            System.out.println("Светофор: Зеленый свет! Машины могут ехать.");
            notifyAll();
        } else {
            System.out.println("Светофор: Красный свет! Машины должны остановиться.");
        }
    }

    public synchronized void waitForGreen(String carName) throws InterruptedException {
        while (!greenLight) {
            System.out.println(carName + " ждет зеленого света.");
            wait();
        }
        System.out.println(carName + " едет.");
    }
}

