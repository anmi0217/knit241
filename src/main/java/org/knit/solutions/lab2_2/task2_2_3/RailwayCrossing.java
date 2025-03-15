package org.knit.solutions.lab2_2.task2_2_3;

public class RailwayCrossing {
    private boolean isTrainOnCrossing = false;

    public synchronized void waitForTrain() throws InterruptedException {
        while (!isTrainOnCrossing) {
            wait();
        }
    }

    public synchronized void trainArrived() {
        isTrainOnCrossing = true;
        System.out.println("🚆 Поезд приближается к переезду! Автомобили останавливаются.");
    }

    public synchronized void trainDeparted() {
        isTrainOnCrossing = false;
        System.out.println("🚆 Поезд проехал. Автомобили продолжают движение.");
        notifyAll();
    }
}
