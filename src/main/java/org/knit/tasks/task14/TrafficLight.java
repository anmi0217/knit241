package org.knit.tasks.task14;

public enum TrafficLight {
    RED, YELLOW, GREEN;

    public TrafficLight getNextLight() {
        switch (this) {
            case RED: return YELLOW;
            case YELLOW: return GREEN;
            default: return RED;
        }
    }
}
