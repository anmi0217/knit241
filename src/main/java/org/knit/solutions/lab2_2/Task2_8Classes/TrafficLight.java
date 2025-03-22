package org.knit.solutions.lab2_2.Task2_8Classes;

public enum TrafficLight {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private final String nextLight;


    TrafficLight(String nextLight) {
        this.nextLight = nextLight;
    }

    public TrafficLight getNext() {
        return TrafficLight.valueOf(nextLight);
    }

}
