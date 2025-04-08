package org.knit.solutions.Task8;


public class Car extends Thread {
    private final TrafficLight trafficLight;
    private final String carName;

    public Car(TrafficLight trafficLight, String carName) {
        this.trafficLight = trafficLight;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                trafficLight.waitForGreen(carName);
                Thread.sleep(2000);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(carName + " остановилась.");
        }
    }
}

