package org.knit.solutions.lab2_4.task2_4_3;

class SwitchOnTV implements Command {
    private final SmartHome smartHome;

    SwitchOnTV(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.SwitchOnTV();
    }

    @Override
    public void undo() {
        smartHome.SwitchOffTV();
    }
}