package org.knit.solutions.lab2_4.task2_4_3;

public class SmartHome {
    private boolean tv = false;
    private boolean light = false;

    public void SwitchOnTV() {
        if (tv) {
            System.out.println("Телевизор и так включен!");
        } else {
            System.out.println("\uD83D\uDCFA✅Телевизор включен");
            tv = true;
        }
    }

    public void SwitchOffTV() {
        if (tv) {
            System.out.println("\uD83D\uDCFA❌Телевизор выключен");
            tv = false;
        } else {
            System.out.println("Телевизор и так выключен");
        }

    }

    public void SwitchOnLight() {
        if (light) {
            System.out.println("Свет и так включен!");
        } else {
            System.out.println("\uD83D\uDCA1✅Свет включен");
            light = true;
        }
    }

    public void SwitchOffLight() {
        if (light) {
            System.out.println("\uD83D\uDCA1❌Свет выключен");
            light = false;
        } else {
            System.out.println("Свет и так выключен!");
        }
    }
}
