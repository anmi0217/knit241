package org.labs.Tasks2.Task4;

public class Car extends Thread {
    private final GasStation gasStation;
    private final String carName;

    public Car(String carName, GasStation gasStation) {
        this.carName = carName;
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        try {
            gasStation.arrive(carName);

            gasStation.refuel(carName);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Машина " + carName + " прервана во время ожидания или заправки.");
        }
    }
}
