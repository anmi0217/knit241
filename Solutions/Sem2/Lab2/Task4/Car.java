package org2.lab4;

class Car implements Runnable {
    private GasStation gasStation;
    private String name;

    public Car(GasStation gasStation, String name) {
        this.gasStation = gasStation;
        this.name = name;
    }

    @Override
    public void run() {
        gasStation.refuel(name); // Машина начинает заправку
    }
}