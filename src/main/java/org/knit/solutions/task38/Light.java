package org.knit.solutions.task38;

public class Light {
    private boolean isOn = false;

    public void turnOn() {
        if (isOn) {
            System.out.println("Свет уже включен.");
        } else {
            isOn = true;
            System.out.println("Свет включен.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Свет выключен.");
        } else {
            System.out.println("Свет уже выключен.");
        }
    }
}
