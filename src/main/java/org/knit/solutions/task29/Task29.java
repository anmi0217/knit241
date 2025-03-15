package org.knit.solutions.task29;

public class Task29 {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> gasStation.refuel(String.valueOf(finalI))).start();
        }
    }
}
