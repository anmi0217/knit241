package org.knit.Solutions.Task6;

public class Car extends Thread{
    private RailroadCrossing crossing;
    private String carName;

    public Car(RailroadCrossing crossing, String carName) {
        this.crossing = crossing;
        this.carName = carName;
    }

    @Override
    public void run() {
        crossing.waitForTrain(carName);
    }
}
