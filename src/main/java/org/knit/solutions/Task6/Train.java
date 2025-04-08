package org.knit.solutions.Task6;


public class Train extends Thread {
    private final RailroadCrossing crossing;

    public Train(RailroadCrossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            while (true) {
                crossing.trainArrives();
                Thread.sleep(3000);
                crossing.trainDeparts();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("🚆 Поезд остановлен.");
        }
    }
}

