package org2.lab4;

class Car extends Thread {
    private final GasStation gasStation;
    private final String name;

    public Car(GasStation gasStation, String name) {
        this.gasStation = gasStation;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            gasStation.refuel(name);
        } catch (InterruptedException e) {
            System.out.println(name + " прервана во время ожидания.");
        }
    }
}