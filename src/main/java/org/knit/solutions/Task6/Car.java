package org.knit.solutions.Task6;


public class Car extends Thread {
    private final RailroadCrossing crossing;
    private final String carName;

    public Car(RailroadCrossing crossing, String carName) {
        this.crossing = crossing;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                crossing.carWaits(carName);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("🚗 " + carName + " остановилась.");
        }
    }
}

