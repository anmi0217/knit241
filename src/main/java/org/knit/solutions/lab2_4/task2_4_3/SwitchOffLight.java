package org.knit.solutions.lab2_4.task2_4_3;

public class SwitchOffLight implements Command  {
    private final SmartHome smartHome;

    SwitchOffLight(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.SwitchOffLight();
    }

    @Override
    public void undo() {
        smartHome.SwitchOnLight();
    }
}
