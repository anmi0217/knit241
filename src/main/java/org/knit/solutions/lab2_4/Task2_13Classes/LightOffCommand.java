package org.knit.solutions.lab2_4.Task2_13Classes;



public class LightOffCommand implements Command{
    private final SmartHouse house;

    @Override
    public void execute() {
        house.turnOffLight();
    }

    @Override
    public void undo() {
        house.turnOnLight();
    }

    public LightOffCommand(SmartHouse house) {
        this.house = house;
    }
}
