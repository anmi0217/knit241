package org.labs.Tasks2.Task6;

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

