package org.knit.solutions.task38;

public class Conditioner {
    private boolean isOn = false;

    public void turnOn() {
        if (isOn) {
            System.out.println("Кондиционер уже включен.");
        } else {
            isOn = true;
            System.out.println("Кондиционер включен.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Кондиционер выключен.");
        } else {
            System.out.println("Кондиционер уже выключен.");
        }
    }
}
