package org.knit.solutions.lab_2_4.Task13;

public class TVOnCommand implements Command {
    private final TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        if (!tv.isOn()) {
            tv.setOn(true);
        } else {
            System.out.println("Телевизор и так включен");
        }
    }

    @Override
    public void undo() {
        if (tv.isOn()) {
            tv.setOn(false);
        } else {
            System.out.println("Телевизор и так выключен");
        }
    }
}
