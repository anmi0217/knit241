package org.knit.Solutions.Task6;

public class Train extends Thread{
    private RailroadCrossing crossing;

    public Train(RailroadCrossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // Поезд приближается
            crossing.trainArrives();
            Thread.sleep(3000); // Поезд проезжает переезд
            crossing.trainDeparts();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
