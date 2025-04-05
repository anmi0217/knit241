package org.knit.solutions.ClassesSem1.lab9.Task14;

public enum TrafficLight {
    RED, YELLOW, GREEN;

    public TrafficLight getNextLight() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}
