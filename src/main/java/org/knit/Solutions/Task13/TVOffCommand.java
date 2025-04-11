package org.knit.Solutions.Task13;

public class TVOffCommand implements Command{
    private final TV tv;

    public TVOffCommand(TV tv){
        this.tv = tv;
    }

    public void execute() {
        tv.off();
    }

    public void undo() {
        tv.on();
    }
}
