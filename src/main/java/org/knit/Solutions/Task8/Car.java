package org.knit.Solutions.Task8;

class Car extends Thread {
    private TrafficLight trafficLight;
    private String carName;

    public Car(TrafficLight trafficLight, String carName) {
        this.trafficLight = trafficLight;
        this.carName = carName;
    }

    @Override
    public void run() {
        trafficLight.waitForGreen(carName);
    }
}
