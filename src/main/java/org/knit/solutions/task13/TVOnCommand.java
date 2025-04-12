package org.knit.solutions.task13;

public class TVOnCommand implements Command{
    private final TV tv;

    public TVOnCommand(TV tv){
        this.tv = tv;
    }

    public void execute() {
        tv.on();
    }

    public void undo() {
        tv.off();
    }
}
