package org.knit.lab2_2.task6;

public class Train extends Thread {
    private final RailwayCrossing crossing;
    private final String trainName;

    public Train(String trainName, RailwayCrossing crossing) {
        this.trainName = trainName;
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            crossing.passByTrain(trainName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(trainName + " был прерван во время проезда.");
        }
    }
}

