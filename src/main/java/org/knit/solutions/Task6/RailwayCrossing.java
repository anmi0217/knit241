package org.labs.Tasks2.Task6;

public class RailwayCrossing {
    private boolean trainOnCrossing = false;

    public synchronized void crossByCar(String carName) throws InterruptedException {
        while (trainOnCrossing) {
            System.out.println(carName + " ждет, так как поезд проезжает.");
            wait();
        }
        System.out.println(carName + " начал(а) пересекать переезд...");
        Thread.sleep(500);
        System.out.println(carName + " успешно проехал(а) переезд!");
    }

    public synchronized void passByTrain(String trainName) throws InterruptedException {
        System.out.println(trainName + " приближается к переезду. Машины должны остановиться.");

        trainOnCrossing = true;
        Thread.sleep(2000);

        System.out.println(trainName + " проехал переезд. Машины могут двигаться.");
        trainOnCrossing = false;
        notifyAll();
    }
}
