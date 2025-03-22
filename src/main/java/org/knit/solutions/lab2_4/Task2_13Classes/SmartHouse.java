package org.knit.solutions.lab2_4.Task2_13Classes;

public class SmartHouse {
    private boolean isTVOn;
    private boolean isLightOn;

    public SmartHouse() {
        isLightOn = false;
        isTVOn = false;
    }

    public void turnOnTV() {
        isTVOn = true;
        System.out.println("Телевизор включился");
    }

    public void turnOffTV() {
        isTVOn = false;
        System.out.println("Телевизор выключился");
    }

    public void turnOnLight() {
        isLightOn = true;
        System.out.println("Свет включился");
    }

    public void turnOffLight() {
        isLightOn = false;
        System.out.println("свет выключился");
    }
}
