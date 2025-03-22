package org.knit.solutions.lab2_4.Task2_13Classes;

public class LightOnCommand implements Command{
    private final SmartHouse house;

    public LightOnCommand(SmartHouse house) {
        this.house = house;
    }

    @Override
    public void execute() {
        house.turnOnLight();
    }

    @Override
    public void undo() {
        house.turnOffLight();
    }
}
