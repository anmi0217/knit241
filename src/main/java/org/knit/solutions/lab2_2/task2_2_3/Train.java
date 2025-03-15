package org.knit.solutions.lab2_2.task2_2_3;

class Train implements Runnable {
    private final RailwayCrossing crossing;

    public Train(RailwayCrossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                crossing.trainArrived();

                Thread.sleep(3000);
                crossing.trainDeparted();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}