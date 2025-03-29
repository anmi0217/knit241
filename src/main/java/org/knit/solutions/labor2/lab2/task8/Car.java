package org.knit.solutions.labor2.lab2.task8;

public class Car {

    private final int number;

    public Car(int number) {
        this.number = number;
    }

    public synchronized void pass(Crossroad crossroad) {
        crossroad.waitForGreen();
        System.out.println("Машина " + number + " проехала перекресток");
    }
}