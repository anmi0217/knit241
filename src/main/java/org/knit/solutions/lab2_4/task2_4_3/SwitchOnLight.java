package org.knit.solutions.lab2_4.task2_4_3;

public class SwitchOnLight implements Command  {
    private final SmartHome smartHome;

    SwitchOnLight(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.SwitchOnLight();
    }

    @Override
    public void undo() {
        smartHome.SwitchOffLight();
    }
}
