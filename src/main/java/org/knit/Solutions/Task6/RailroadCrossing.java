package org.knit.Solutions.Task6;

public class RailroadCrossing {
    private boolean trainApproaching = false;

    public synchronized void waitForTrain(String carName) {
        while (trainApproaching) {
            try {
                System.out.println(carName + " остановился перед переездом и ждет проезда поезда...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(carName + " проехал переезд.");
    }

    public synchronized void trainArrives() {
        System.out.println("Поезд приближается! Машины должны остановиться.");
        trainApproaching = true;
    }

    public synchronized void trainDeparts() {
        System.out.println("Поезд проехал! Машины могут двигаться.");
        trainApproaching = false;
        notifyAll();
    }
}
