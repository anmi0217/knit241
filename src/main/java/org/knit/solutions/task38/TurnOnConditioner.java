package org.knit.solutions.task38;

public class TurnOnConditioner implements Command {
    private final Conditioner conditioner;

    public TurnOnConditioner(Conditioner conditioner) {
        this.conditioner = conditioner;
    }

    @Override
    public void execute() {
        conditioner.turnOn();
    }

    @Override
    public void undo() {
        conditioner.turnOff();
    }
}
