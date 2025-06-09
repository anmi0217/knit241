package org2.lab8;

class Car implements Runnable {
    private final TrafficLight trafficLight;
    private final String name;

    public Car(TrafficLight trafficLight, String name) {
        this.trafficLight = trafficLight;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) { // Машины постоянно пытаются проехать перекресток
                trafficLight.drive(name);
                Thread.sleep(1000); // Имитация времени между попытками проезда
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " прерван.");
        }
    }
}
