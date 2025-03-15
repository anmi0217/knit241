package org.labs.Tasks2.Task6;

public class Car extends Thread {
    private final RailwayCrossing crossing;
    private final String carName;

    public Car(String carName, RailwayCrossing crossing) {
        this.carName = carName;
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            crossing.crossByCar(carName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(carName + " был(а) прерван(а) во время ожидания/проезда.");
        }
    }
}
