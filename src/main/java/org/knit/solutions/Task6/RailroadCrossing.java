package org.knit.solutions.Task6;


public class RailroadCrossing {
    private boolean trainApproaching = false;

    public synchronized void trainArrives() throws InterruptedException {
        trainApproaching = true;
        System.out.println("🚆 Поезд приближается! Машины останавливаются.");
        Thread.sleep(2000);
    }

    public synchronized void trainDeparts() {
        trainApproaching = false;
        System.out.println("🚆 Поезд уехал! Машины могут продолжить движение.");
        notifyAll();
    }

    public synchronized void carWaits(String carName) throws InterruptedException {
        while (trainApproaching) {
            System.out.println("🚗 " + carName + " ждёт, пока проедет поезд.");
            wait();
        }
        System.out.println("🚗 " + carName + " продолжает движение.");
    }
}
