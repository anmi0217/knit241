package org.knit.Solutions.Task4;

class Car extends Thread {
    private String carName;
    private GasStation station;

    public Car(String carName, GasStation station) {
        this.station = station;
        this.carName = carName;
    }

    @Override
    public void run() {
        station.refuel(carName);
    }
}
