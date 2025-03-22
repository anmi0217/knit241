package org.knit.solutions.lab2_4.Task2_13Classes;

public class TVOffCommand implements Command {
    private final SmartHouse house;

    public TVOffCommand(SmartHouse house) {
        this.house = house;
    }

    @Override
    public void execute() {
        house.turnOffTV();
    }

    @Override
    public void undo() {
        house.turnOnTV();
    }
}
