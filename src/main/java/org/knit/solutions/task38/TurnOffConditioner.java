package org.knit.solutions.task38;

public class TurnOffConditioner implements Command {
    private final Conditioner conditioner;

    public TurnOffConditioner(Conditioner conditioner) {
        this.conditioner = conditioner;
    }

    @Override
    public void execute() {
        conditioner.turnOff();
    }

    @Override
    public void undo() {
        conditioner.turnOn();
    }
}
