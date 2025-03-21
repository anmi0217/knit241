package org.knit.solutions.lab2_4.task2_4_3;

public class SwitchOffTV implements Command {
    private final SmartHome smartHome;

    SwitchOffTV(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.SwitchOffTV();
    }

    @Override
    public void undo() {
        smartHome.SwitchOnTV();
    }
}
