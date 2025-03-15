package org.dina.lab2_2.Task2_8;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public synchronized void pass(TrafficLight trafficLight) {
        trafficLight.waitForGreen();
        System.out.println("Машина " + name + " проехала перекресток");
    }
}