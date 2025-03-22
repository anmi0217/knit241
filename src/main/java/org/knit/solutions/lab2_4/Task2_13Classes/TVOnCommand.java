package org.knit.solutions.lab2_4.Task2_13Classes;

public class TVOnCommand implements Command{
    private final SmartHouse house;

    public TVOnCommand(SmartHouse house) {
        this.house = house;
    }

    @Override
    public void execute() {
        house.turnOnTV();
    }

    @Override
    public void undo() {
        house.turnOffTV();
    }
}
