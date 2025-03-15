package org.knit.solutions.Task13;

public class AirConditioner {
    private final String location;
    public AirConditioner(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println("Кондиционер в " + location + " включен.");
    }
    public void off() {
        System.out.println("Кондиционер в " + location + " выключен.");
    }
}

