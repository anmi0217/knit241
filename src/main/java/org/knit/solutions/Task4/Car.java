package org.knit.solutions.Task4;

public class Car extends Thread {
    private final GasStation gasStation;
    private final String name;

    public Car(GasStation gasStation, String name) {
        this.gasStation = gasStation;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " стоит в очереди.");
            gasStation.acquirePump(name);
            Thread.sleep(2000);
            gasStation.releasePump(name);
            System.out.println(name + " заправилась и уехала.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
