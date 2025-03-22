package org.knit.solutions.lab2_2.Task2_4Classes;


import org.knit.solutions.lab2_2.Task2_6Classes.Machine;

public class Car extends Thread implements Machine {

    private int fuel;
    private final GasStation gasStation;

    public Car(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        try {
            gasStation.fillUp(this);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void increaseFuel() {
        if (fuel < 50) {
            fuel += 20;
        }
        if (fuel > 50) {
            fuel = 50;
        }
    }


    public Car() {
        gasStation = null;
    }
}
