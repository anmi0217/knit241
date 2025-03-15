package org.knit.solutions.Task13;

public class AirConditionerOnCommand implements Command {
    private final AirConditioner ac;
    public AirConditionerOnCommand(AirConditioner ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.on();
    }
    @Override
    public void undo() {
        ac.off();
    }
}
