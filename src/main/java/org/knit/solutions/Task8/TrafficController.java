package org.knit.solutions.Task8;


public class TrafficController extends Thread {
    private final TrafficLight trafficLight;

    public TrafficController(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                trafficLight.switchLight();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

